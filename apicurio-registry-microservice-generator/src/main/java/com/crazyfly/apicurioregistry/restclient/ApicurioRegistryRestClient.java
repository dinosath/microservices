package com.crazyfly.apicurioregistry.restclient;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/apis/registry/v2/groups/openapi")
@RegisterRestClient
public interface ApicurioRegistryRestClient {

    @Path("/artifacts/{artifactId}")
    @GET
    Uni<String> getArtifact(@PathParam("artifactId") String artifactId);

}
