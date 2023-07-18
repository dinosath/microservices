package com.crazyfly.resources;

import com.crazyfly.models.OpenApiGeneratorRequest;
import com.crazyfly.services.JobGeneratorService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import javax.validation.Valid;

@Path("/oas_gen/generate")
public class GeneratorJobResource {

    @Inject
    JobGeneratorService jobGeneratorService;
    
    @POST
    public void generate(@Valid OpenApiGeneratorRequest openApiGeneratorRequest){
        jobGeneratorService.generateJob(openApiGeneratorRequest.openApiUrl(),openApiGeneratorRequest.oasGenTemplateId());
    }
}
