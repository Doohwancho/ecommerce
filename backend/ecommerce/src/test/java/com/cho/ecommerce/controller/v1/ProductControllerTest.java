package com.cho.ecommerce.controller.v1;

import com.cho.ecommerce.common.BaseControllerTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


import java.util.HashMap;
import java.util.Map;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
public class ProductControllerTest extends BaseControllerTest {

    @Test
    @DisplayName("상품 등록")
    public void testCreateProduct() {
        Map<String, Object> product = new HashMap<>();
        product.put("name", "test");
        product.put("price", 1000);
        product.put("description", "test");

        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(product)
                .when()
                    .post("http://localhost:8080/v1/products")
                .then()
                    .log().all()
                    .statusCode(HttpStatus.CREATED.value())
                    .body("name", equalTo("test"))
                    .body("price", equalTo(1000))
                    .body("description", equalTo("test"));
    }

    @Test
    @DisplayName("상품 id로 조회")
    public void testGetProduct() {
        createProduct();

        RestAssured
                .given()
                .when()
                    .get("http://localhost:8080/v1/products/{id}", 1)
                .then()
                    .log().all()
                    .statusCode(HttpStatus.OK.value());
    }

    @Test
    @DisplayName("상품 정보 업데이트")
    public void testUpdateProduct() {
//        createProduct();
//
//        Map<String, Object> product = new HashMap<>();
//        product.put("name", "updatedTest");
//        product.put("price", 2000);
//        product.put("description", "updatedTest");
//
//        RestAssured
//                .given()
//                    .contentType(ContentType.JSON)
//                    .accept(ContentType.JSON)
//                    .body(product)
//                .when()
//                    .put("http://localhost:8080/v1/products/1000000", 1)
//                .then()
//                    .log().all()
//                    .statusCode(HttpStatus.OK.value())
//                    .body("name", equalTo("updatedTest"))
//                    .body("price", equalTo(2000))
//                    .body("description", equalTo("updatedTest"));

        ExtractableResponse<Response> create = createProduct();

        Map<String, Object> params = new HashMap<>();
        params.put("name", "updatedTest");
        params.put("price", 2000);
        params.put("description", "updatedTest");

        ExtractableResponse<Response> updateStudy = RestAssured
                .given().log().all()
                .body(params)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .put(create.header("Location"))
                .then().log().all()
                .extract();

        assertThat(updateStudy.statusCode()).isEqualTo(HttpStatus.NO_CONTENT.value());
    }

    @Test
    @DisplayName("상품 삭제")
    public void testDeleteProduct() {
//        createProduct();
//
//        RestAssured
//                .given()
//                .when()
//                    .delete("http://localhost:8080/v1/products/1000000", 1)
//                .then()
//                    .log().all()
//                    .statusCode(HttpStatus.OK.value());
        ExtractableResponse<Response> create = createProduct();

        ExtractableResponse<Response> deleteProduct = RestAssured
                .when()
                    .delete(create.header("Location"))
                .then().log().all()
                    .extract();

        assertThat(deleteProduct.statusCode()).isEqualTo(HttpStatus.NO_CONTENT.value());
    }




    /***************************************************
     * helper functions
     */

    private ExtractableResponse<Response> createProduct() {
        Map<String, Object> params = new HashMap<>();
        params.put("id", 1000000);
        params.put("name", "test");
        params.put("price", 1000);
        params.put("description", "test");

        return RestAssured.given().log().all()
                .body(params)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when()
                .post("/v1/product")
                .then().log().body()
                .extract();
    }

}
