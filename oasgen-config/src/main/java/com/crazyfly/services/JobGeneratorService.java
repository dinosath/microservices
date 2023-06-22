package com.crazyfly.services;

import com.crazyfly.models.Artifact;

import io.fabric8.kubernetes.api.model.PersistentVolumeClaimVolumeSource;
import io.fabric8.kubernetes.api.model.batch.v1.Job;
import io.fabric8.kubernetes.api.model.batch.v1.JobBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;

@ApplicationScoped
public class JobGeneratorService {

    private static final org.jboss.logging.Logger logger = Logger.getLogger(JobGeneratorService.class);

    @Inject
    private KubernetesClient kubernetesClient;
    
    public void generateJob(String openApiUrl){

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

                //download 
                //  .addNewInitContainer()
                //  .withName("download-template")
                //  .withImage("busybox")
                //  .withArgs("sh", "-c","cd /openapigenerator && wget https://github.com/dinosath/openapi-generator-templates/archive/refs/heads/main.zip && unzip main.zip 'openapi-generator-templates-main' -d /openapigenerator/quarkus")
                //  .addNewVolumeMount()
                //  .withName("oasgen-pv")
                //  .withMountPath("/openapigenerator")
                //  .endVolumeMount()
                //  .endInitContainer()

                //extract
                .addNewInitContainer()
                .withName("unzip")
                .withImage("busybox")
                .withArgs("ls","/data")
                .addNewVolumeMount()
                .withName("oasgen-pv")
                .withMountPath("/data")
                .endVolumeMount()
                .endInitContainer()


                .addNewInitContainer()
                .withName("openapi-generator-cli")
                .withImage("openapitools/openapi-generator-cli")
                .withArgs("generate", "-i", openApiUrl,"-c","/data/quarkus/config.yaml","-o","/data/out")
                .addNewVolumeMount()
                .withName("oasgen-pv")
                .withMountPath("/data")
                .endVolumeMount()
                .endInitContainer()
                
                .addNewInitContainer()
                .withName("maven")
                .withImage("maven:3-eclipse-temurin-17-alpine")
                .withWorkingDir("/openapigenerator/out")
                .withArgs("mvn","package","-Pnative")
                .addNewVolumeMount()
                .withName("oasgen-pv")
                .withMountPath("/openapigenerator")
                .endVolumeMount()
                .addNewVolumeMount()
                .withName("m2-volume")
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
                .withName("oasgen-pv")
                .withPersistentVolumeClaim(new PersistentVolumeClaimVolumeSource("oasgen-pvc", false))
                .endVolume()

                .addNewVolume()
                .withName("m2-volume")
                .withPersistentVolumeClaim(new PersistentVolumeClaimVolumeSource("m2-repository-pvc", false))
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
}
