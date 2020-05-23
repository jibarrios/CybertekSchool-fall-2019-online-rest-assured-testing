package com.automation.tests.day6;

import com.automation.pojos.Student;
import com.automation.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;

public class POJOPracticeWithPreschool {

    @BeforeAll
    public static void setup() {
        baseURI = ConfigurationReader.getProperty("PRESCHOOL.URI");
    }

    @Test
    public void addStudentTest() {
        File file = new File("student.json");
        Response response = given().
                contentType(ContentType.JSON).
                body(file).
                when().
                post("/student/create").prettyPeek();

        int studentId = response.jsonPath().getInt("studentId");
        System.out.println("Student id: " + studentId);
    }

    @Test
    public void getStudentTest(){
        Response response = get("/student/{id}", 11613).prettyPeek();
        Student student = response.jsonPath().getObject("students[0]", Student.class);
        System.out.println(student);
    }
}
