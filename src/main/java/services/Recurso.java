package services;

import org.glassfish.jersey.server.ResourceConfig;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("services")
public class Recurso extends ResourceConfig {
    public Recurso() {
        packages("rest");
} }