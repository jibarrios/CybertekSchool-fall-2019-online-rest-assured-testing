package com.automation.tests.day3;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

public class ORDSTestsDay3 {

    @BeforeAll
    public static void setup() {
        baseURI = "http://54.224.118.38:1000/ords/hr";
    }

    /**
     * given resource path is "/regions/{id}"
     * when user makes get request
     * and region id is equals to 1
     * then assert that status code is 200
     * and assert that region name is Europe
     * and assert that region id is 1
     */

    @Test
    public void verifyFirstRegion() {
        given().
                pathParam("id", 1).
                when().
                get("/regions/{id}").prettyPeek().
                then().assertThat().
                statusCode(200).
                body("region_name", is("Europe")).
                body("region_id", is(1)).
                time(lessThan(5L), TimeUnit.SECONDS); //verify that response time is less than 5 seconds

    }

    @Test
    public void verifyEmployee() {
        Response response = given().
                accept(ContentType.JSON).
                when().
                get("/employees");

        /**
         * sonPath is an alternative to using XPath for easily getting values from a Object document. It follows the
         *  * Groovy <a href="http://docs.groovy-lang.org/latest/html/documentation/#_gpath">GPath</a>
         *  syntax when getting an object from the document. You can regard it as an alternative to XPath for JSON.
         */
        JsonPath jsonPath = response.jsonPath();

        //items - name of the array where all employees are stored
        //GPath, something like XPath bit different. GPath use Groovy syntax
        String nameOfFirstEmployee = jsonPath.getString("items[0].first_name");//0 - to get first item in the list
        String nameOfLastEmployee = jsonPath.getString("items[-1].first_name");//-1 - to get last item in the list, like length() - n


        Map<String, ?> searchByName = jsonPath.get("items.find{it.last_name == 'Hunold'}");
        String searchByEmail = jsonPath.get("items.find{it.email == 'BERNST'}.last_name");
        String maxSalary = jsonPath.get("items.max{it.salary}.last_name");

        System.out.println(searchByName);
        System.out.println(searchByEmail);
        System.out.println(maxSalary);

        System.out.println("First name of 1st employee: " + nameOfFirstEmployee);
        System.out.println("First name of last employee: " + nameOfLastEmployee);


        Map<String, ?> firstEmployee = jsonPath.get("items[0]");
        System.out.println(firstEmployee);
    }


}
