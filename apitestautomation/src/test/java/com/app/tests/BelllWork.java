package com.app.tests;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BelllWork {
    @BeforeClass
    public static void setUp(){
        RestAssured.baseURI="https://api.got.show";
}


     @Test
    public void getAllBattles(){
        given().when().get("/api/show/battles/").prettyPrint();
     }
    @Test
    public void getSomeBattlesByName(){
        given().
                pathParam("name","Ambush at Dragonstone").
                when().
                get("/api/show/battles/{name}").
                prettyPrint();






    }
}
