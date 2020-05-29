package com.automation.tests.day9;

import com.automation.utilities.ConfigurationReader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class SchemaValidation {

    @BeforeAll
    public static void beforeAll() {
        baseURI = ConfigurationReader.getProperty("SPARTAN.URI");
        authentication = basic("admin", "admin");
    }


    @Test
    public void schemaValidationTest(){

    }
}
