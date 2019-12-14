package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class QuerryParamExample {
    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "https://uinames.com/api/";

    }

    @Test
    public void uiNameByAmount() {
        given().
                queryParam("amount", "3").
                when().
                get().prettyPrint();

    }

    @Test
    public void iuNameByCountry() {
        given().
                queryParam("region", "Turkey").
                when().
                get().prettyPrint();


    }

    @Test
    public void uiNamesby() {
        given().queryParam("amount", "5").
                given().queryParam("region", "France").
                when().get().prettyPrint();

    }

    @Test
    public void uiNamesbyAmoungGender() {
        given().queryParam("amount", "3").
                given().queryParam("gender", "male").
                when().get().prettyPrint();
    }
}
