package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PathParameterExample {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI="https://api.got.show";

    }
    @Test
    public void getAnimalByHabitat(){
        //given () will prepare your request
        given().
                 //setting the path parameter
                pathParam("habitat","Jungles").
                //sending the request
                when().
                get("/api/show/animals/byHabitat/{habitat}").
                //printing the request
                prettyPrint();
    }

    @Test
    public void getAnimalByName(){

        given().pathParam("name","Manticores").
                when().
                get("/api/show/animals/{name}").prettyPrint();
    }

    }

