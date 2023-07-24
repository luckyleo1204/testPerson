package com.murali.ecomercesite.pageObjects.ApiTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTesting {


    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;
    }

    @Test
    public void queryParamExample() {

        String idToGet = "2";
        String expectedTitle = "With the Beatles";

        // @formatter:off
        given().
                param("id", idToGet).
                when().
                get("albums").
                then().
                assertThat().
                body("title[0]", equalToIgnoringCase(expectedTitle));
        // @formatter:on
    }

    @Test
    public void queryParamExample1() {

        Integer expectedId = 2;
        String titleToGet = "With the Beatles";

        // @formatter:off
        given().
                param("title", titleToGet).
                when().
                get("albums").
                then().
                assertThat().
                body("id[0]", equalTo(expectedId));
        // @formatter:on
    }

    @Test
    public void extractDataAndPassToNextAPICall() {

        // @formatter:off
        Response response = given().
                when().
                get("albums").
                then().
                extract().
                response();
        String validId = response.jsonPath().getString("id[0]");
        String validTitle = response.jsonPath().getString("title[0]");

        given().
                pathParam("id", validId).
                when().
                get("albums/{id}").
                then().
                assertThat().
                body("title", equalTo(validTitle));
        // @formatter:on
    }

    @Test
    public void postNewAlbum() {

       Header acceptJson = new Header("Accept", "application/json");

        JSONObject requestParams = new JSONObject();
        requestParams.put("artist", "The Beatles - Murali");
        requestParams.put("title", "Rubber Soul- Murali");
        requestParams.put("year", "1978");

        // @formatter:off
        //add the new album
        Response response =
                given().
                        contentType(ContentType.JSON).
                        header(acceptJson).
                        body(requestParams.toString()).
                        when().
                        post("/albums").
                        then().
                        statusCode(201).
                        body("$", hasKey("id")).
                        body("title",equalTo("Rubber Soul- Murali")).
                        body("year",equalTo("1978")).
                        extract().response();
        // @formatter:on
    }

    @Test
    public void postNewAlbumThenDelete() {

        Header acceptJson = new Header("Accept", "application/json");

        JSONObject requestParams = new JSONObject();
        requestParams.put("artist", "The Beatles");
        requestParams.put("title", "A Hard Day's Night");
        requestParams.put("year", "1964");

        // @formatter:off
        //add the new album
        Response response =
                given().
                        contentType(ContentType.JSON).
                        body(requestParams.toString()).
                        when().
                        post("/albums").
                        then().
                        statusCode(201).
                        body("$", hasKey("id")).
                        body("title",equalTo("A Hard Day's Night")).
                        body("year",equalTo("1964")).
                        extract().response();

        //delete album that was just added
        given().
                contentType(ContentType.JSON).
                body(requestParams.toString()).
                when().
                delete("/albums/" + response.jsonPath().getInt("id")).
                then().
                statusCode(200);

        //try to get the album we just deleted
        given().
                when().
                get("/albums/" + response.jsonPath().getInt("id")).
                then().
                statusCode(404);

        // @formatter:on
    }

    @Test(enabled = false)
    public void getExample(){
        given().
                when()
                .get("http://dummy.restapiexample.com/api/v1/employees")
                .then()
                .assertThat()
                .log()
                .ifValidationFails()
                .statusCode(200);


    }
}
