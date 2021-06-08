package com.thecat.authentication.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import com.thecat.authentication.model.User;
import com.thecat.authentication.rest.client.UserService;

@Path("/authenticate")
public class Authenticate {

    private static final Logger LOG = Logger.getLogger(Authenticate.class);
    
    @Inject
    @RestClient
    private UserService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String authenticate(User user ) {

        LOG.info( "Login rest endpoint " + user.toString() + " " + user.getPassword() );
        int statusCode = service.login(user);
        LOG.info( "Status after service call " + statusCode );

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