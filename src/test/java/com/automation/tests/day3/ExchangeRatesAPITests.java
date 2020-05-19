package com.automation.tests.day3;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ExchangeRatesAPITests {

    /**
     *  * <p>{@code @BeforeAll} methods must have a {@code void} return type,
     *  * must not be {@code private}, and must be {@code static} by default.
     */
    @BeforeAll // must be static
    public static void setup(){
        //for every single request this is a base URI
        baseURI = "http://api.openrates.io";
    }

    //get latest currency rates

    @Test
    public void getLatestRates(){
        Response response = get("/latest").prettyPeek();

        //verify that GET request to the endpoint was successful
        response.then().assertThat().statusCode(200);
    }
}
