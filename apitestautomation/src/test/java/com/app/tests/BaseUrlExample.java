package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BaseUrlExample {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI="https://reqres.in/api/";
        //setting up the base url for each request that will be sent in each test

    }
    @Test
    public static void singleUserTest(){
        Response response=RestAssured.get("users/2");
        response.prettyPrint();
        Assert.assertTrue(response.asString().contains("Janet"));


    }

    }


