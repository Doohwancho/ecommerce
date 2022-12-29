package com.cho.ecommerce.controller.v1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.Rollback;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
public class ProductControllerTest {

    @Test
    @DisplayName("상품 등록")
    @Rollback
    public void registerProduct() {
        Map<String, Object> product = new HashMap<>();
        product.put("name", "test");
        product.put("description", "test");
        product.put("sku","test");

        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(product)
                .when()
                    .post("/v1/product")
                .then()
                    .log().all()
                    .statusCode(HttpStatus.CREATED.value())
                    .body("name", equalTo("test"))
                    .body("description", equalTo("test"))
                    .body("sku", equalTo("test"));
    }
}
