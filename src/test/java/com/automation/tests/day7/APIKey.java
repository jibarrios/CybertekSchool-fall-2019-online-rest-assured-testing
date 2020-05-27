package com.automation.tests.day7;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

public class APIKey {

    private final String API_KEY = "29055371";

    @BeforeAll
    public static void setup(){
        baseURI = "http://omdbapi.com/";
    }

    @Test
    public void getMovieTest(){
        String itemToSearch = "Frozen";
        given().
                queryParam("t", itemToSearch).
                queryParam("apikey", API_KEY).
        when().
                get().prettyPeek().
        then().
                assertThat().
                statusCode(200).
                body("Title", containsString(itemToSearch));
    }
}
