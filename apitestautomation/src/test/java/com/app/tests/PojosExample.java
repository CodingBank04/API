package com.app.tests;

import com.app.tests.Pojos.Person;
import com.google.gson.Gson;
import org.junit.Test;

public class PojosExample {


    @Test
    public void test() {
        Person person = new Person();
        person.setName("jake");
        person.setSurname("Oconnor");
        person.setGender("male");
        person.setRegion("United States");
        System.out.println("printing person java object :" + person);
//serrialization
        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println("printing json object: " + json);
        //deserrialization
        String myJsonString = "{\"name\":\"Maria\"," +
                "\"surmane\":\"Oconnor\"," +
                "\"gender\":\"female\"," +
                "\"region\":\"United States\"}";
        Person myPerson = gson.fromJson(myJsonString, Person.class);
        System.out.println("printing new person java object: " + myPerson);
    }


    @Test
    public void test2() {
        Person person = new Person();
        person.setName("jake");
        person.setSurname("Oconnor");
        person.setGender("male");
        person.setRegion("United States");

        System.out.println("printing person object: " + person);


       // ObjectMapper objectMapper = new ObjectMapper();
       // String json=objectMapper.write


    }
}