package com.thecat.authentication.service.endpoint;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AuthenticateTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/authenticate/health")
          .then()
             .statusCode(200)
             .body(is("SUCCESS"));
    }

}