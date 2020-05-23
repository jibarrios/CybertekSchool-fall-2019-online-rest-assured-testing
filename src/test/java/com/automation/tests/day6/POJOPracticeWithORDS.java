package com.automation.tests.day6;

import com.automation.utilities.ConfigurationReader;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;


public class POJOPracticeWithORDS {

    @BeforeAll
    public static void setup() {
        baseURI = ConfigurationReader.getProperty("ORDS.URI");
    }



}
