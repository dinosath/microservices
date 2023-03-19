package com.crazyfly.resources;

import com.crazyfly.models.OasGeneratorConfig;
import org.bson.types.ObjectId;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/oas_gen/configs")
public class OpenApiGeneratorConfigResource {

    private static final Logger logger = Logger.getLogger(OpenApiGeneratorConfigResource.class);


    @GET
    public List<OasGeneratorConfig> getConfigs() {
        return OasGeneratorConfig.listAll();
    }

    @POST
    public OasGeneratorConfig getConfigs(@Valid OasGeneratorConfig oasGeneratorConfig) {
        oasGeneratorConfig.persist();
        logger.debug("Created oasGeneratorConfig:"+oasGeneratorConfig.id);
        return oasGeneratorConfig;
    }

    @Path("/{id}")
    @DELETE
    public Response deleteConfig(@PathParam("id") ObjectId id) {
        logger.debug("deleteting "+id);
        boolean deleted = OasGeneratorConfig.deleteById(id);
        return deleted ? Response.noContent().build() : Response.status(404).build();
    }


}
