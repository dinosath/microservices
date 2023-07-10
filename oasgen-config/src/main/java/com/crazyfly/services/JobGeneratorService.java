package com.crazyfly.services;

import io.fabric8.kubernetes.api.model.*;
import io.fabric8.kubernetes.api.model.batch.v1.Job;
import io.fabric8.kubernetes.api.model.batch.v1.JobBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@ApplicationScoped
public class JobGeneratorService {

    private static final org.jboss.logging.Logger logger = Logger.getLogger(JobGeneratorService.class);

    @Inject
    private KubernetesClient kubernetesClient;
    
    public void generateJob(String openApiUrl){

        createPvIfNotExists("oasgen","oasgen","0.5","/data/oasgen");
        createPvcIfNotExists("oasgen","oasgen","0.5");

        createPvIfNotExists("m2","m2","5","/data/m2");
        createPvcIfNotExists("m2","m2","5");



        final Job job = new JobBuilder()
                .withApiVersion("batch/v1")
                .withNewMetadata()
                .withGenerateName("generate-openapi")
                .endMetadata()
                .withNewSpec()
                .withNewTemplate()
                .withNewMetadata()
                .withName("sequential-job")
                .endMetadata()
                .withNewSpec()

                //TODO issue with downloading and extracting the folder
                .addNewInitContainer()
                .withName("download-template")
                .withImage("busybox")
                .withArgs("sh", "-c","cd /openapigenerator && wget --no-check-certificate https://github.com/dinosath/openapi-generator-templates/archive/refs/heads/main.zip && unzip main.zip && mv openapi-generator-templates-main/* ./")
                .addNewVolumeMount()
                .withName("oasgen")
                .withMountPath("/openapigenerator")
                .endVolumeMount()
                .endInitContainer()

                //extract
                .addNewInitContainer()
                .withName("unzip")
                .withImage("busybox")
                .withArgs("ls","/data")
                .addNewVolumeMount()
                .withName("oasgen")
                .withMountPath("/data")
                .endVolumeMount()
                .endInitContainer()


                .addNewInitContainer()
                .withName("openapi-generator-cli")
                .withImage("openapitools/openapi-generator-cli")
                .withArgs("generate", "-i", openApiUrl,"-c","/data/quarkus/config.yaml","-o","/data/out")
                .addNewVolumeMount()
                .withName("oasgen")
                .withMountPath("/data")
                .endVolumeMount()
                .endInitContainer()
                
                .addNewInitContainer()
                .withName("maven")
                .withImage("maven:3-eclipse-temurin-17-alpine")
                .withWorkingDir("/openapigenerator/out")
                .withArgs("mvn","package","-Pnative")
                .addNewVolumeMount()
                .withName("oasgen")
                .withMountPath("/openapigenerator")
                .endVolumeMount()
                .addNewVolumeMount()
                .withName("m2")
                .withMountPath("/root/.m2")
                .endVolumeMount()
                .endInitContainer()

                .addNewContainer()
                .withName("job-done")
                .withImage("image: busybox")
                .withArgs("sh","c",  "tail -f /dev/null")
                .endContainer()

                .withRestartPolicy("Never")
                .addNewVolume()
                .withName("oasgen")
                .withPersistentVolumeClaim(new PersistentVolumeClaimVolumeSource("oasgen", false))
                .endVolume()

                .addNewVolume()
                .withName("m2")
                .withPersistentVolumeClaim(new PersistentVolumeClaimVolumeSource("m2", false))
                .endVolume()

                .endSpec()
                .endTemplate()
                .withParallelism(1)
                .withCompletions(1)
                .withBackoffLimit(1)
                .endSpec()
                .build();

        kubernetesClient.batch().v1().jobs().inNamespace("default")
                .resource(job).create();

    }

    private void createPvcIfNotExists(String name,String storageClassName,String storageAmount){
        if(kubernetesClient.persistentVolumeClaims().inNamespace("default").list().getItems().stream().map(PersistentVolumeClaim::getMetadata).map(ObjectMeta::getName).noneMatch(name::equals)){
            final PersistentVolumeClaim pvc = new PersistentVolumeClaimBuilder()
                    .withApiVersion("v1")
                    .withNewMetadata()
                    .withName(name)
                    .endMetadata()
                    .withNewSpec()
                    .withStorageClassName(storageClassName)
                    .withAccessModes(List.of("ReadWriteMany"))
                    .withNewResources()
                    .withRequests(Map.<String, Quantity>of("storage",new QuantityBuilder().withAmount(storageAmount)
                            .withFormat("Gi").build()))
                    .endResources()
                    .endSpec()
                    .build();

            kubernetesClient.persistentVolumeClaims().inNamespace("default").resource(pvc).create();
        }
    }

    private void createPvIfNotExists(String name,String storageClassName,String storageAmount,String path){

        if(kubernetesClient.persistentVolumes().list().getItems().stream().map(PersistentVolume::getMetadata).map(ObjectMeta::getName).noneMatch(name::equals)){
            final PersistentVolume pv = new PersistentVolumeBuilder()
                    .withApiVersion("v1")
                    .withNewMetadata()
                    .withName(name)
                    .endMetadata()
                    .withNewSpec()
                    .withStorageClassName(storageClassName)
                    .withCapacity(Map.<String, Quantity>of("storage",new QuantityBuilder().withAmount(storageAmount)
                            .withFormat("Gi").build()))
                    .withAccessModes(List.of("ReadWriteMany"))
                    .withNewHostPath()
                    .withPath(path)
                    .endHostPath()
                    .endSpec()
                    .build();

            kubernetesClient.persistentVolumes().resource(pv).create();
        }

    }
}
