package com.cho.ecommerce.controller.v1;

import com.cho.ecommerce.entity.Category;
import com.cho.ecommerce.entity.Product;
import com.cho.ecommerce.util.GsonUtils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.hamcrest.Matchers.equalTo;

//TODO - delete test products created from this test, due to @Transactional not supported for rollback
//TODO - controller validation check test
//TODO - end to end scenario test

//@Transactional //db transaction rollback is not supported when you apply it directly from the "web layer". ref: https://stackoverflow.com/questions/46729849/transactions-in-spring-boot-testing-not-rolled-back
@SpringBootTest
public class ProductControllerTest {

    @Test
    @DisplayName("상품 등록")
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
                .quantityInStock(100)
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
                    .post("/v1/products")
                .then()
                    .log().all()
                    .statusCode(HttpStatus.CREATED.value())
                    .body("name", equalTo("test"))
                    .body("description", equalTo("test"))
                    .body("sku", equalTo("test"));
    }


    @Test
    @DisplayName("특정 카테고리에 속하는 상품 전체 검색")
    public void queryAllProductThatBelongsToCertainCategory() {
        //given
        Long categoryId = 1L;

        Category category = new Category().builder()
                .id(categoryId)
                .parentId(0L)
                .name("men")
                .build();

        Product product1 = new Product().builder()
                .name("test-product1")
                .description("check-here")
                .sku("test")
                .price(10000)
                .quantityInStock(100)
                .category(category)
                .build();
        Product product2 = new Product().builder()
                .name("test-product2")
                .description("check-here")
                .sku("test")
                .price(10000)
                .quantityInStock(100)
                .category(category)
                .build();

        String productJson1 = GsonUtils.toJson(product1);
        String productJson2 = GsonUtils.toJson(product2);

        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(productJson1)
                .when()
                    .post("/v1/products")
                .then()
                    .log().all()
                    .statusCode(HttpStatus.CREATED.value())
                    .body("name", equalTo("test-product1"));
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(productJson2)
                .when()
                    .post("/v1/products")
                .then()
                    .log().all()
                    .statusCode(HttpStatus.CREATED.value())
                    .body("name", equalTo("test-product2"));

        //when, then
        Response response = RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(productJson1)
                .when()
                    .get("/v1/categories/"+categoryId+"/products")
                .then()
                .log().all()
                .statusCode(HttpStatus.OK.value())
                .extract().response();

        Assertions.assertThat(response.jsonPath().getList("any").size()).isGreaterThanOrEqualTo(2);
        Assertions.assertThat(response.getBody().asString().contains("test-product1")).isTrue();
        Assertions.assertThat(response.getBody().asString().contains("test-product2")).isTrue();
    }
}
