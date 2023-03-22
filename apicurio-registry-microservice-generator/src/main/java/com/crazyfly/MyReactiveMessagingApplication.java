package com.crazyfly;

import com.crazyfly.apicurioregistry.models.events.ArtifactCreated;
import com.crazyfly.apicurioregistry.restclient.ApicurioRegistryRestClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.smallrye.mutiny.Uni;
import io.smallrye.reactive.messaging.ce.IncomingCloudEventMetadata;
import org.eclipse.microprofile.reactive.messaging.*;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.IOException;
import java.util.concurrent.CompletionStage;

import static io.opentelemetry.api.internal.ValidationUtil.log;
import static java.time.Duration.ofMillis;

@ApplicationScoped
public class MyReactiveMessagingApplication {

    private static final Logger LOGGER = Logger.getLogger(MyReactiveMessagingApplication.class);

    @Inject
    @RestClient
    ApicurioRegistryRestClient apicurioRegistryRestClient;


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
            ArtifactCreated artifactCreated = objectMapper.readValue(message.getPayload(),ArtifactCreated.class);
            LOGGER.debug("artifactId:"+artifactCreated.artifactId());

            Uni<String> response = apicurioRegistryRestClient.getArtifact(artifactCreated.artifactId());
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
