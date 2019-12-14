package com.app.tests;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
public class Validation {

    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI="https://uinames.com/api/";

    }
    @Test
    public void test1(){
        //given() preparing our request
        given().
                //when is where we submit our request
        // get() is our method in which you provide the end point or url
        when().get().
                //then is where you verify the response statusCode, etc
        then().statusCode(200);
    }
    @Test
    public void test2(){
        // passing wrong url, verify if the status code is 404.
        given().
                when().get("8766").then().statusCode(404);
    }
    @Test
    public void headerSet(){
        given().get().
                then().log().headers().
                header("Content-Type","application/json; charset=utf-8");

    }
    @Test
    public void testbody(){
        given().
                when().get().
                then().assertThat().body("name",notNullValue());

    }
    @Test
    public void testGender(){
        //want to verify if the names i get female or males
        String gender="female";
        given().
                queryParam("gender","female").
                when().get().then().log().body().assertThat().body("gender",is(gender));

    }
    @Test
    public void testRegion(){
        String region="France";
        given().
                queryParam("region",region);
                 when().get().then().log().body().
                         assertThat().body("region", is(region));

    }
    @Test
    public  void testAmount(){
        given().queryParam("amount",4).
                when().get().
                then().log().body().assertThat().body("region", hasSize(4));


    }
    @Test
    public void basicAuth(){
        given().
                auth().basic("path","path").
                when().get("https://httpbin.org/basic-auth/path/path").then().log().body();
    }

}
