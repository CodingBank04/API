package com.app.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class WarmUp {

    @Test
    public void test1() {
        Response response = RestAssured.get("https://api.got.show/api/show/animals/");
        response.prettyPrint();
        String responseAssString = response.asString();
        Assert.assertTrue(responseAssString.contains("habitat"));

        int actualStatusCode = response.statusCode();
        Assert.assertEquals(200, actualStatusCode);
}
}