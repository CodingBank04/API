package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class SimpleRestExample {
    @Test
    public void test1() {
        // Rest assured library will prepare and set the url
        Response response = RestAssured.get("https://uinames.com/api/");
        //to print the response
        System.out.println(response);
        response.prettyPrint();
        // asString ---> will convert our object into string
        String responseAssString = response.asString();
        Assert.assertTrue(responseAssString.contains("name"));
        Assert.assertTrue(responseAssString.contains("surname"));

        int actualStatusCode = response.statusCode();
        Assert.assertEquals(200, actualStatusCode);

    }

    @Test
    public void headersTest() {
        Response response = RestAssured.get("https://uinames.com/api/");

        String actualContent = response.contentType();
        System.out.println(actualContent);

        Assert.assertEquals("application/json; charset=utf-8\n", actualContent);


    }

   @Test
    public void statusLineTest() {
        Response response = RestAssured.get("https://uinames.com/api/");
        String statusLine = response.statusLine();
        System.out.println(statusLine);
        Assert.assertTrue(statusLine.contains("200"));
        Assert.assertTrue(statusLine.contains("OK"));


    }

    @Test
    public void getAllUsers() {
        BaseUrlExample.setUp();
        BaseUrlExample.singleUserTest();


    }

    @Test
    public  void multipleUserTest() {
        Response response = RestAssured.get("page=2");
        response.prettyPrint();
        int actualStatusCode = response.statusCode();
       // String statusLine = response.statusLine();
        Assert.assertEquals(200, actualStatusCode);
        Assert.assertTrue(response.asString().contains("id"));


    }

}
