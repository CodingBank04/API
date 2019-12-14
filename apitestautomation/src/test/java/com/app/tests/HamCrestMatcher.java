package com.app.tests;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HamCrestMatcher {
    private Object String;
    private Object Matchers;

    @Test
    public void test(){
        assertThat(5,equalTo(5));
        String str1="sdet";
        String str2="sdet";

        assertThat(str1,is("sdet"));
        assertThat(str1,is(str2));

        assertThat(str1, is(not("qa")));

        assertThat(str1,equalToIgnoringCase("sdeT"));

        assertThat(str1,equalToIgnoringCase(" sdet"));

        assertThat(5,greaterThan(3));

        assertThat(4, lessThan(4));

        assertThat(7,lessThanOrEqualTo(8));


        assertThat(str1,notNullValue());

        List<String> list= Arrays.asList("key","store", "order");

       // assertThat(list, Matchers<String> hasSize(3));






    }

}
