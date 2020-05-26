package com.automation.review;

import com.automation.pojos.Spartan;
import com.automation.utilities.ConfigurationReader;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static io.restassured.RestAssured.*;

public class WeatherAPP {
    @BeforeAll
    public static void beforeAll() {
        baseURI = ConfigurationReader.getProperty("SPARTAN.URI");
        authentication = basic("admin", "admin");
    }


    public static void main(String[] args) {
        JPanel jPanel = new JPanel();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter city name: ");
        String city = scanner.nextLine();
        String woeid = getWOEID(city);
        printWeatherInfo(woeid);
    }

    public static String getWOEID(String city) {
        Response response = given().queryParam("query", city).get("/search");
        String woeid = response.jsonPath().getString("woeid");
        return woeid;
    }

    public static void printWeatherInfo(String woeid) {
        woeid = woeid.replaceAll("\\D", "");//to delete all non-digits
        Response response = get("{woeid}", woeid);
        List<String> weatherStateName = response.jsonPath().getList("consolidated_weather.weather_state_name");
        List<Float> temp = response.jsonPath().getList("consolidated_weather.the_temp");
        List<String> dates = response.jsonPath().getList("consolidated_weather.applicable_date");
        System.out.println("Here is the weather forecast for this week:");
        for (int i = 0; i < weatherStateName.size(); i++) {
            String date = dates.get(i);
            float tempF = temp.get(i) * 9/5 + 32;
            date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")).format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
            System.out.printf("Date: %s, Weather state: %s, Temperature %.0f F\n", date, weatherStateName.get(i), tempF);
        }
    }

    // Reverse order --> how we create Java object and send it to the to create a USER
    @Test
    public void addUser(){
        Spartan spartan = new Spartan("Vasil", "Male", 3471222582L);
        Gson gson = new Gson();
        String pojoAsJson = gson.toJson(spartan);
        System.out.println(pojoAsJson);
        // this is the way how we should create new obj and send it to the server
        Response response = given().
                auth().basic("admin", "admin").
                contentType(ContentType.JSON).
                body(spartan).
                when().
                post("/spartans").prettyPeek();
        response.then().statusCode(201);//to ensure that user was created
        int usersId = response.jsonPath().getInt("data.id");
        System.out.println("Users id :: " + usersId);
        System.out.println("####DELETE USER####");
        given().
                auth().basic("admin", "admin").
                when().
                delete("/spartans/{id}", usersId).prettyPeek().
                then().
                assertThat().statusCode(204);//to ensure that user was deleted
    }


}
