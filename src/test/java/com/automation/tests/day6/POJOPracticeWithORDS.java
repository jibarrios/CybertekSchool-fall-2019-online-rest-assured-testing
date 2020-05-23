package com.automation.tests.day6;

import com.automation.pojos.Employee;
import com.automation.utilities.ConfigurationReader;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;


public class POJOPracticeWithORDS {

    @BeforeAll
    public static void setup() {
        baseURI = ConfigurationReader.getProperty("ORDS.URI");
    }

    @Test
    public void getEmployeeTest(){
        Response response = get("/employees/{id}", 100).prettyPeek();

        Employee employee = response.as(Employee.class);
    }

}
