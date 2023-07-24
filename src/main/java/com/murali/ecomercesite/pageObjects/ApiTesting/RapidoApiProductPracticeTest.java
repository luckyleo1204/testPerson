package com.murali.ecomercesite.pageObjects.ApiTesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class RapidoApiProductPracticeTest {

    RequestSpecification resp;
    @BeforeMethod
    public void setup() {

       // RestAssured.baseURI = "https://ap-southeast-2.aws.webhooks.mongodb-stitch.com";
        resp =RestAssured.given().header("x-api-key", "qi842sQCczEFvon5cKJWpRlaRWqxoIBbufpidrOkLJ4TTtnWkORrQbjYol1mEQyD")
                .baseUri("https://ap-southeast-2.aws.webhooks.mongodb-stitch.com");
    }

    @Test
    public void GetApi_001() {
        Response res = resp.given()
                .queryParam("page", 1)
                .when()
                .get("/api/client/v2.0/app/rapido-demo-qlxye/service/api/incoming_webhook/products");
        System.out.println(res.getStatusCode());
        System.out.println(res.asPrettyString());
        Assert.assertEquals(res.getStatusCode(), 200);
    }
    @Test
    public void GetApi_002(){
        Response res=resp.given()
                .queryParam("page", -1)
                .when()
                .get("/api/client/v2.0/app/rapido-demo-qlxye/service/api/incoming_webhook/products");
        System.out.println(res.getStatusCode());
        System.out.println(res.asPrettyString());
        Assert.assertEquals(res.getStatusCode(), 200);
    }
    @Test
    public void GetApi_003_InvalidAuth(){
        Response res=resp.given()
                .header("x-api-key", "qi842sQCczEFvon5cKJWpRlaRWqxoIBbufpidrOkLJ4TTtnWkORrQbjYol1mEQyD12121")
                .queryParam("page", 1)
                .when()
                .get("/api/client/v2.0/app/rapido-demo-qlxye/service/api/incoming_webhook/products");
        System.out.println(res.getStatusCode());
        System.out.println(res.asPrettyString());
        Assert.assertEquals(res.getStatusCode(), 401);
    }
    @Test
    public void GetApi_004_NoAuth(){
        Response res=resp.given()
                .header("x-api-key","")
                .queryParam("pages",1)
                .when()
                .get("/api/client/v2.0/app/rapido-demo-qlxye/service/api/incoming_webhook/products");
        System.out.println(res.getStatusCode());
        System.out.println(res.asPrettyString());
        Assert.assertEquals(res.getStatusCode(), 403);
    }
}
