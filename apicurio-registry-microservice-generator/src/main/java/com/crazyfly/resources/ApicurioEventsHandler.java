package com.crazyfly.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.smallrye.reactive.messaging.ce.IncomingCloudEventMetadata;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.CompletionStage;


@ApplicationScoped
public class ApicurioEventsHandler {
    private static final Logger LOGGER = Logger.getLogger(ApicurioEventsHandler.class);

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
//            ArtifactId artifactId = objectMapper.readValue(message.getPayload(), ArtifactId.class);
//            String openAPIUrl = String.format("%s/apis/registry/v2/groups/%s/artifacts/%s",registryUrl,artifactId.getGroupId(),artifactId.getArtifactId());
//            LOGGER.debug("openAPIUrl:"+openAPIUrl);

        return message.ack();
    }

}
