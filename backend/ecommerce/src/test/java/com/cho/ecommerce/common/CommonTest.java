package com.cho.ecommerce.common;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommonTest {
    @Test
    public void testIfJunit5Works(){
        assert true;
    }

    @Test
    public void testRestAssuredWorks(){
        RestAssured.
                given().
//                    auth().
//                    oauth2("myAuthenticationToken").
        when().
                header("Content-Type","application/json").
//                    param(null).
//                    body(null).
        get("https://reqres.in/api/users"). //or post(), update(), delete()
                then().
                assertThat().
                statusCode(200).
                log().all();
    }
}
