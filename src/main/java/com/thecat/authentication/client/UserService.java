package com.thecat.authentication.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.thecat.authentication.model.User;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path( "/user" )
@RegisterRestClient
public interface UserService {
    
    @POST
    @Consumes( MediaType.APPLICATION_JSON)
    public int login( User user );
}
