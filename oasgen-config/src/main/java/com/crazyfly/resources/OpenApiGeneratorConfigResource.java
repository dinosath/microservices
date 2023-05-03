package com.crazyfly.resources;

import com.crazyfly.models.OasGeneratorConfig;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
@Path("/oas_gen/configs")
public class OpenApiGeneratorConfigResource {
    private static final Logger logger = Logger.getLogger(OpenApiGeneratorConfigResource.class);

    @Channel("oasgen-config-events")
    Emitter<String> emitter;

    @GET
    public List<OasGeneratorConfig> getConfigs() {
        return OasGeneratorConfig.listAll();
    }

    @POST
    public Uni<OasGeneratorConfig> createConfig(@Valid OasGeneratorConfig oasGeneratorConfig) {
        emitter.send("creating new oasgen");
        oasGeneratorConfig.persist();
        logger.debug("Created oasGeneratorConfig:"+oasGeneratorConfig.id);
        emitter.send(String.valueOf(oasGeneratorConfig.id));
        return Uni.createFrom().item(oasGeneratorConfig);
    }

    @Path("/{id}")
    @DELETE
    public Response deleteConfig(@PathParam("id") ObjectId id) {
        logger.debug("deleteting "+id);
        boolean deleted = OasGeneratorConfig.deleteById(id);
        return deleted ? Response.noContent().build() : Response.status(404).build();
    }


}
