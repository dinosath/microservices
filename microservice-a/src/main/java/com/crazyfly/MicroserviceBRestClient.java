package com.crazyfly;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RegisterRestClient(configKey="microservice-b-client")
public interface MicroserviceBRestClient {

    @Path("/hello")
    @GET
    Uni<String> hello();
}
