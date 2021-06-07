package com.thecat.authentication.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.thecat.authentication.service.AuthenticationService;
import com.thecat.authentication.model.User;

@Path("/authenticate")
public class Authenticate {

    @Inject
    private AuthenticationService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String login(User user ) {
     return service.login(user);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path( "/health")
    public String health() {
        return "SUCCESS";
    }
}