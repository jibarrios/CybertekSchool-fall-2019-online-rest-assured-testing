package com.automation.tests.day2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class ORDSTests {
    String BASE_URL = "http://3.90.112.152:1000/ords/hr";

    @Test
    @DisplayName("Get list of all employees")
    public void getAllEmployees() {
        Response response = given().
                                baseUri(BASE_URL).
                            when().
                                get("/employees").prettyPeek();
    }
}
