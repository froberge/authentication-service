package com.thecat.authentication.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.thecat.authentication.model.User;
import com.thecat.authentication.rest.client.UserService;

@Path("/authenticate")
public class Authenticate {

    @Inject
    @RestClient
    private UserService service;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String login(User user ) {

        int statusCode = service.login(user);
    
        String message;

        if ( statusCode == Status.OK.getStatusCode() )
            message =  "SUCCESS";
        else if ( statusCode == Status.NO_CONTENT.getStatusCode() )
            message = "NOT_FOUND";
        else if ( statusCode == Status.PARTIAL_CONTENT.getStatusCode() )
            message = "WRONG_CREDENTIAL";
        else
            message = "SERVICE_NOT_FOUND";

        return message;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path( "/health")
    public String health() {
        return "SUCCESS";
    }
}