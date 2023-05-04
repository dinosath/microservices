package com.crazyfly.resources;

import com.crazyfly.models.GeneratorJobCreate;
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
    public void generate(@Valid GeneratorJobCreate generatorJobCreate){
        generatorJobCreate.getArtifacts().forEach(artifact -> jobGeneratorService.generateJob(artifact));
    }
}
