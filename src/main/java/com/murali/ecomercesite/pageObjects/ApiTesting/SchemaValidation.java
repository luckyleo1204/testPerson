package com.murali.ecomercesite.pageObjects.ApiTesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class SchemaValidation {


    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;
    }
    @Test
    public void checkAlbumSchema() {
        // @formatter:off
        given().
                when().
                get("albums/1").
                then().
                log().ifValidationFails().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON).
                body(matchesJsonSchemaInClasspath("album_schema.json"));
        // @formatter:on
    }
    @Test
    public void checkAlbumsSchema() {
        // @formatter:off
        given().
                when().
                get("albums").
                then().
                log().ifValidationFails().
                assertThat().
                statusCode(200).
                and().
                contentType(ContentType.JSON).
                body(matchesJsonSchemaInClasspath("./music-dbSchema.json"));
        // @formatter:on
    }
}
