package com.crazyfly;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServiceBService {

    @RestClient
    MicroserviceBRestClient microserviceBRestClient;

    public Uni<String> hello(){
        return microserviceBRestClient.hello();
    }
}
