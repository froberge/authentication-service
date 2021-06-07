package com.thecat.authentication.service;

import javax.enterprise.context.ApplicationScoped;
import com.thecat.authentication.model.User;

/**
 * AuthenticationService
 */
@ApplicationScoped
public class AuthenticationService {

    public String login( User user ) {
        return user.toString();
    }
}