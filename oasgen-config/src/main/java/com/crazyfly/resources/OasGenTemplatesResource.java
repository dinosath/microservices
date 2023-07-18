package com.crazyfly.resources;

import com.crazyfly.models.OasGenTemplate;
import com.crazyfly.services.OasGenTemplateCrudService;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
@Path("/oas-gen/templates")
public class OasGenTemplatesResource {
    private static final Logger logger = Logger.getLogger(OasGenTemplatesResource.class);

    @Inject
    OasGenTemplateCrudService oasGenTemplateCrudService;

    @GET
    public Uni<List<OasGenTemplate>> getOasGenTemplates() {
        return oasGenTemplateCrudService.getOasGenTemplates();
    }

    @POST
    public Uni<OasGenTemplate> createOasGenTemplate(@Valid OasGenTemplate oasGenTemplate) {
        return oasGenTemplateCrudService.createOasGenTemplate(oasGenTemplate);
    }

    @PUT
    @Path("/{id}")
    public Uni<OasGenTemplate> createOasGenTemplate(@PathParam("id") int id, @Valid OasGenTemplate oasGenTemplate){
        return oasGenTemplateCrudService.updateOasGenTemplate(id,oasGenTemplate);
    }

    @Path("/{id}")
    @DELETE
    public Uni<OasGenTemplate> deleteOasGenTemplate(@PathParam("id") int id) {
        return oasGenTemplateCrudService.deleteOasGenTemplate(id);
    }


}
