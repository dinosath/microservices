package com.crazyfly.resources;

import com.crazyfly.models.OasGenTemplate;
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
public class OasGenTemplateConfigResource {
    private static final Logger logger = Logger.getLogger(OasGenTemplateConfigResource.class);

    @Channel("oasgen-config-events")
    Emitter<String> emitter;

    @GET
    public List<OasGenTemplate> getConfigs() {
        return OasGenTemplate.listAll();
    }

    @POST
    public Uni<OasGenTemplate> createConfig(@Valid OasGenTemplate oasGenTemplate) {
        emitter.send("creating new oasgen");
        oasGenTemplate.persist();
        logger.debug("Created oasGeneratorConfig:"+ oasGenTemplate.id);
        emitter.send(String.valueOf(oasGenTemplate.id));
        return Uni.createFrom().item(oasGenTemplate);
    }

    @PUT
    @Path("/{id}")
    public Uni<Void> updateConfig(@PathParam("id") ObjectId id,@Valid OasGenTemplate oasGenTemplate){
        oasGenTemplate.id = id;
        oasGenTemplate.update();
        emitter.send("OASGEN_CONFIG_UPDATE");
        return Uni.createFrom().voidItem();
    }

    @Path("/{id}")
    @DELETE
    public Response deleteConfig(@PathParam("id") ObjectId id) {
        logger.debug("deleteting "+id);
        boolean deleted = OasGenTemplate.deleteById(id);
        return deleted ? Response.noContent().build() : Response.status(404).build();
    }


}
