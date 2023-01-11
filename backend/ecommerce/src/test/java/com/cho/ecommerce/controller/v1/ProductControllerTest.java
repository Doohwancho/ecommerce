package com.cho.ecommerce.controller.v1;

import com.cho.ecommerce.entity.Category;
import com.cho.ecommerce.entity.Product;
import com.cho.ecommerce.util.GsonUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.Rollback;

import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
public class ProductControllerTest {

    @Test
    @DisplayName("상품 등록")
    @Rollback
    public void registerProduct() {
        //given
        Category category = new Category().builder()
                .id(1L)
                .parentId(0L)
                .name("men")
                .build();

        Product product = new Product().builder()
                .name("test")
                .description("test")
                .sku("test")
                .price(10000)
                .quantity_in_stock(100)
                .category(category)
                .build();

        String productJson = GsonUtils.toJson(product);

        //when, then
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(productJson)
                .when()
                    .post("/v1/product")
                .then()
                    .log().all()
                    .statusCode(HttpStatus.CREATED.value())
                    .body("name", equalTo("test"))
                    .body("description", equalTo("test"))
                    .body("sku", equalTo("test"));
    }

    //TODO - controller validation check test
    //TODO - end to end scenario test
}
