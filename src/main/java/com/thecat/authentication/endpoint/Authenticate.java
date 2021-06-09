package com.thecat.authentication.endpoint;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import com.thecat.authentication.client.UserService;
import com.thecat.authentication.model.User;

@Path("/authenticate")
public class Authenticate {

    private static final Logger LOG = Logger.getLogger(Authenticate.class);
    
    @Inject
    @RestClient
    private UserService service;

    @Operation(
        summary = "Authenticate user ",
        description = "Authenticate a user to the application"
    )
    @APIResponse(
        responseCode = "SUCCESS",
        description = "User was authenticated"
    )
    @APIResponse(
        responseCode = "WRONG_CREDENTIAL",
        description = "User can't be found or something was wrong"
    )
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String authenticate(User user ) {

        LOG.info( "Login rest endpoint " + user.toString() + " " + user.getPassword() );
        int statusCode = service.login(user);
        LOG.info( "Status after service call " + statusCode );

        String message;
        if ( statusCode == Status.OK.getStatusCode() )
            message =  "SUCCESS";
        else
            message = "WRONG_CREDENTIAL";

        return message;
    }

    @Operation(
        summary = "Validate if the service is up",
        description = "Use this service to validate if the service is up and running."
    )
    @APIResponse(
        responseCode = "200",
        description = "Service is answering"
    )
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path( "/health")
    public int health() {
        return Response.Status.OK.getStatusCode();
    }
}