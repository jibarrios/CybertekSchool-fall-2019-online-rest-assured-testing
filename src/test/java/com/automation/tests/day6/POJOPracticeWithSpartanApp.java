package com.automation.tests.day6;

import com.automation.pojos.Spartan;
import com.automation.utilities.ConfigurationReader;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

public class POJOPracticeWithSpartanApp {

    @BeforeAll
    public static void beforeAll() {
        baseURI = ConfigurationReader.getProperty("SPARTAN.URI");
        authentication = basic("admin", "admin");
    }

    @Test
    public void addSpartanTest() {
        /**
         * {
         *   "gender": "Male",
         *   "name": "Nursultan",
         *   "phone": "123112312312"
         * }
         */

        Map<String, String> spartan = new HashMap<>();
        spartan.put("gender", "Male");
        spartan.put("name", "Nursultan");
        spartan.put("phone", "123112312312");

        RequestSpecification requestSpecification = given().
                auth().basic("admin", "admin").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(spartan);

        Response response = given().
                auth().basic("admin", "admin").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(spartan).
                when().
                post("/spartans").prettyPeek();

        response.then().statusCode(201);
        response.then().body("success", is("A Spartan is Born!"));

        //deserialization
        Spartan spartanResponse = response.jsonPath().getObject("data", Spartan.class);
        Map<String, Object> spartanResponseMap = response.jsonPath().getObject("data", Map.class);

        System.out.println(spartanResponse);
        System.out.println(spartanResponseMap);

        //spartanResponse is a Spartan
        System.out.println(spartanResponse instanceof Spartan);// must be true
    }

    @Test
    @DisplayName("Retrieve exiting user, update his name and verify that name was updated successfully.")
    public void updateSpartanTest() {
        int userToUpdate = 101;
        String name = "Nursultan";

        //HTTP PUT request to update exiting record, for example exiting spartan.
        //PUT - requires to provide ALL parameters in body
        //PUT requires same body as POST
        //If you miss at least one parameter, it will not work

        Spartan spartan = new Spartan(name, "Male", 123112312312L);

        //get spartan from web service
        Spartan spartanToUpdate = given().
                auth().basic("admin", "admin").
                accept(ContentType.JSON).
                when().
                get("/spartans/{id}", userToUpdate).as(Spartan.class);
        //update property that you need without affecting other properties
        System.out.println("Before update: " + spartanToUpdate);
        spartanToUpdate.setName(name);//change only name
        System.out.println("After update: " + spartanToUpdate);

        //request to update existing user with id 101
        Response response = given().
                auth().basic("admin", "admin").
                contentType(ContentType.JSON).
                body(spartanToUpdate).
                when().
                put("/spartans/{id}", userToUpdate).prettyPeek();

        //verify that status code is 204 after update
        response.then().statusCode(204);
        System.out.println("##############################################");
        //to get user with id 101, the one that we've just updated
        given().
                auth().basic("admin", "admin").
                when().
                get("/spartans/{id}", userToUpdate).prettyPeek().
                then().
                statusCode(200).body("name", is(name));
        //verify that name is correct, after update
    }

    @Test
    @DisplayName("Verify that user can perform PATCH request")
    public void patchUserTest1() {
        //PATCH - partial update of existing record

        int userId = 21;//user to update, make user with this id exist

        //let's pu the code to take random user
        //get all spartans
        Response response0 = given().accept(ContentType.JSON).when().get("/spartans").prettyPeek();
        //I can save them all in the array list
        List<Spartan> allSpartans = response0.jsonPath().getList("", Spartan.class);
        //Spartan.class - data type of collection
        //getList - get JSON body as a list

        //generate random number
        Random random = new Random();

        int randomNum = random.nextInt(allSpartans.size());

        int randomUserID = allSpartans.get(randomNum).getId();
        System.out.println("NAME BEFORE: " + allSpartans.get(randomNum).getName());

        userId = randomUserID;//to assign random user id
        System.out.println(allSpartans);

        Map<String, String> update = new HashMap<>();
        update.put("name", "Nursultan");
        //this is a request to update user
        Response response = given().
                contentType(ContentType.JSON).
                body(update).
                when().
                patch("/spartans/{id}", userId);

        response.then().assertThat().statusCode(204);

        //after we sent PATCH request, let's make sure that name is updated
        //this is a request to verify that name was updated and status code is correct as well
        given().
                accept(ContentType.JSON).
                when().
                get("/spartans/{id}", userId).prettyPeek().
                then().
                assertThat().statusCode(200).body("name", is("Nursultan"));
    }


}
