package com.crazyfly.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.apicurio.registry.events.dto.ArtifactId;
import io.apicurio.registry.rest.client.RegistryClient;
import io.apicurio.registry.rest.client.RegistryClientFactory;
import io.smallrye.reactive.messaging.ce.IncomingCloudEventMetadata;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletionStage;


@ApplicationScoped
public class EventsHandler {

    private static final Logger LOGGER = Logger.getLogger(EventsHandler.class);
    private static final RegistryClient registryClient;

    static {
        String registryUrl = System.getenv("REGISTRY_URL");
        registryClient = RegistryClientFactory.create(registryUrl);
    }

    @ConfigProperty(name = "apicurio.registry.url",defaultValue = "http://apicurio-registry:8080")
    String registryUrl;

    @Incoming("registry-events")
    public CompletionStage<Void> consumeRegistryEvents(Message<String> message) {

        IncomingCloudEventMetadata<Integer> cloudEventMetadata = message.getMetadata(IncomingCloudEventMetadata.class)
            .orElseThrow(() -> new IllegalArgumentException("Expected a Cloud Event"));

        LOGGER.debug(String.format("Received Cloud Events (spec-version: %s): source:  '%s', type: '%s', subject: '%s' ",
            cloudEventMetadata.getSpecVersion(),
            cloudEventMetadata.getSource(),
            cloudEventMetadata.getType(),
            cloudEventMetadata.getSubject().orElse("no subject")));
        LOGGER.debug("message.payload:"+message.getPayload());
        LOGGER.debug("message :"+cloudEventMetadata.getExtensions().toString()   );
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ArtifactId artifactId = objectMapper.readValue(message.getPayload(), ArtifactId.class);
            String openAPIUrl = String.format("%s/apis/registry/v2/groups/%s/artifacts/%s",registryUrl,artifactId.getGroupId(),artifactId.getArtifactId());



            return response.subscribeAsCompletionStage()
                .thenAccept(s -> {
                    LOGGER.debug("👍👍👍👍👍");
                });
        } catch (JsonProcessingException e) {
            LOGGER.error(String.format("Message payload {%s} cannot be deserialized to class ArtifactCreated due to %s",message.getPayload(),e.getMessage()));
        }
        return message.ack();
    }

}
