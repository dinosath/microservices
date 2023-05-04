package com.crazyfly.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.smallrye.mutiny.Uni;
import io.smallrye.reactive.messaging.ce.IncomingCloudEventMetadata;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.jboss.logging.Logger;

@ApplicationScoped
public class ApicurioEventsHandler {
    private static final Logger LOGGER = Logger.getLogger(ApicurioEventsHandler.class);

    private KubernetesClient kubernetesClient;

    public ApicurioEventsHandler(KubernetesClient kubernetesClient){
        this.kubernetesClient = kubernetesClient;
    }

    @Incoming("registry-events")
    public Uni<Void> consumeRegistryEvents(Message<String> message) {
        LOGGER.info("message:" + message);
        message.getMetadata(IncomingCloudEventMetadata.class)
                .ifPresent(cloudEventMetadata -> {
                    LOGGER.debug(String.format(
                            "Received Cloud Events (spec-version: %s): source:  \"%s\", type: \"%s\", subject: \"%s\" ",
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
