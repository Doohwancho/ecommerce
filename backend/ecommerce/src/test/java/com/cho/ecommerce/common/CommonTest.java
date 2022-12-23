package com.cho.ecommerce.common;

import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommonTest {
    @Test
    @DisplayName("Junit5 작동 여부 테스트")
    public void testIfJunit5Works(){
        assert true;
    }

    @Test
    @DisplayName("RestAssured 작동 여부 테스트")
    public void testRestAssuredWorks(){
        RestAssured.
                given().
                when().
                    header("Content-Type","application/json").
                    get("https://reqres.in/api/users"). //or post(), update(), delete()
                then().
                    assertThat().
                    statusCode(200).
                    log().all();
    }
}
