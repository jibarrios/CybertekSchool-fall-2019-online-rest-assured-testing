package com.automation.tests.day8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;


public class BearerAuthentication {

    @BeforeAll
    public static void setup(){
        baseURI = "https://cybertek-reservation-api-qa.herokuapp.com/";
    }

    @Test
    public void loginTest(){
        given().
                queryParam("email", "teacherva5@gmail.com").
                queryParam("password", "maxpayne").
        when().
                get("/sign").prettyPeek();
    }
}
