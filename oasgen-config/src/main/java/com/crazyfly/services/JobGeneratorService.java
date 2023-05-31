package com.crazyfly.services;

import com.crazyfly.models.Artifact;
import io.apicurio.registry.rest.client.RegistryClient;
import io.apicurio.registry.rest.client.RegistryClientFactory;
import io.fabric8.kubernetes.api.model.batch.v1.Job;
import io.fabric8.kubernetes.api.model.batch.v1.JobBuilder;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import java.io.InputStream;

@ApplicationScoped
public class JobGeneratorService {

    private static final org.jboss.logging.Logger logger = Logger.getLogger(JobGeneratorService.class);
    @ConfigProperty(name = "apicurio.registry.url", defaultValue = "http://apicurio-registry:8080")
    String registryUrl;


    RegistryClient client;

    @Inject
    private KubernetesClient kubernetesClient;

    public void init(@Observes StartupEvent ev) {
        RegistryClient client = RegistryClientFactory.create(registryUrl+"/apis/registry/v2");
    }
    public void generateJob(Artifact artifact){
        String registryUrl = "http://localhost:8090/apis/registry/v2";
        RegistryClient client = RegistryClientFactory.create(registryUrl);


        try {
            InputStream artifactInputStream = client.getLatestArtifact(artifact.getGroupId()!=null?artifact.getGroupId():"default",artifact.getId());
            logger.debug("retrieved latest artifact with id:"+artifact.getId());
        }catch (io.apicurio.registry.rest.client.exception.RestClientException e){
            throw new WebApplicationException("Connection error with apicurio registry url:"+registryUrl);
        }

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
                .addNewInitContainer()
                .withName("openapi-generator-cli")
                .withImage("openapitools/openapi-generator-cli")
                .withArgs("generate", "-g", "java", "-i", "https://petstore3.swagger.io/api/v3/openapi.json","-o","/local")
                .addNewVolumeMount()
                .withName("shared-data")
                .withMountPath("/local")
                .endVolumeMount()
                .endInitContainer()
                .addNewInitContainer()
                .withName("maven")
                .withImage("maven:3-eclipse-temurin-8-alpine")
                .withWorkingDir("/local")
                .withArgs("mvn","package","-Pnative")
                .addNewVolumeMount()
                .withName("shared-data")
                .withMountPath("/local")
                .endVolumeMount()
                .endInitContainer()
                .addNewContainer()
                .withName("job-done")
                .withImage("image: busybox")
                .withArgs("sh","c", "echo job-1 and job-2 completed")
                .endContainer()
                .withRestartPolicy("Never")
                .addNewVolume()
                .withName("shared-data")
                .withNewEmptyDir()
                .endEmptyDir()
                .endVolume()
                .endSpec()
                .endTemplate()
                .endSpec()
                .build();

        kubernetesClient.batch().v1().jobs().inNamespace("default")
                .resource(job).create();

    }
}
