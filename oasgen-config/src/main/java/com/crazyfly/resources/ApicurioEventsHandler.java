package com.crazyfly.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.smallrye.mutiny.Uni;
import io.smallrye.reactive.messaging.ce.IncomingCloudEventMetadata;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.jboss.logging.Logger;


import java.util.Optional;
import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class ApicurioEventsHandler {
    private static final Logger LOGGER = Logger.getLogger(ApicurioEventsHandler.class);

    @ConfigProperty(name = "apicurio.registry.url", defaultValue = "http://apicurio-registry:8080")
    String registryUrl;

    @Incoming("registry-events")
    public Uni<Void> consumeRegistryEvents(Message<String> message) {
        LOGGER.info("message:" + message);
        message.getMetadata(IncomingCloudEventMetadata.class)
                .ifPresent(cloudEventMetadata -> {
                    LOGGER.debug(String.format(
                            "Received Cloud Events (spec-version: %s): source:  '%s', type: '%s', subject: '%s' ",
                            cloudEventMetadata.getSpecVersion(),
                            cloudEventMetadata.getSource(),
                            cloudEventMetadata.getType(),
                            cloudEventMetadata.getSubject().orElse("no subject")));
                    LOGGER.debug("message.payload:" + message.getPayload());
                    LOGGER.debug("message :" + cloudEventMetadata.getExtensions().toString());
                    ObjectMapper objectMapper = new ObjectMapper();
                });
        return Uni.createFrom().completionStage(message.ack());
    }

}
