package com.cho.ecommerce.reference;

import org.junit.jupiter.api.Test;

public class RestAssuredReference {
    /**
     * RestAssured 공식가이드에 따라 Request 값만 세팅해서 확인함.
     */
    @Test
    void RestAssured_공식문서_유저가이드_요청_세팅() {
        // Parameters
//        RestAssured
//                .given().log().all()
//                    .param("name1", "value1")
//                    .param("name2", "value2")
//                .when()
//                    .get("/study");
//
//        RestAssured
//                .given().log().all()
//                    .param("name1", "value1")
//                    .param("name2", "value2")
//                .when()
//                    .post("/study");
//
//        RestAssured
//                .given().log().all()
//                    .formParam("formParamName", "formValue")
//                    .queryParam("queryParamName", "queryValue");

//        RestAssured.when()
//                    .get("/study?topic=RestAssued");
//
//        // multi-value parameters
//        RestAssured
//                .given()
//                .param("name1", "value1", "value2");
//
//        List<String> values = new ArrayList<String>();
//        values.add("value1");
//        values.add("value2");
//
//        RestAssured
//                .given()
//                .param("name1", values);
//
//        // no-value parameters
//        RestAssured
//                .given()
//                .param("name");
//
//        // path parameters
//        RestAssured
//                .when()
//                .post("/study/{topic}/{status}", "RestAssured", "모집중");
//
//        RestAssured
//                .given()
//                    .pathParam("topic", "RestAssured")
//                    .pathParam("status", "모집중")
//                .when()
//                    .post("/study/{topic}/{status}");
//
//
//        Map<String, Object> pathMap = new HashMap<>();
//        pathMap.put("topic", "Acceptance");
//        pathMap.put("status", "모집중");
//
//        RestAssured
//                .given()
//                    .pathParams(pathMap)
//                .when()
//                    .post("/study/{topic}/{status}");

//        // Cookies 쿠키
//        RestAssured.given().log().all()
//                .cookie("topic", "rest-assured")
//                .when().get("/study");
//
//
//        RestAssured.given().log().all()
//                .cookie("topic", "rest1", "rest2")
//                .when().get("/study");
//
//        Cookie topicCookie = new Cookie.Builder("topic", "rest-assured")
//                .setSecured(true)
//                .setComment("Rest Assured study")
//                .build();
//
//        RestAssured.given().log().all()
//                .cookie(topicCookie)
//                .when().get("/study");
//
//        Cookie cookie1  = new Cookie.Builder("name1", "loop").build();
//        Cookie cookie2  = new Cookie.Builder("name2", "study").build();
//        Cookies cookies = new Cookies(cookie1, cookie2);
//
//        RestAssured.given().log().all()
//                .cookies(cookies)
//                .when().get("/study");
//
//        // Headers
//        RestAssured.given().log().all()
//                .header("MyHeader", "Something")

//        RestAssured.given().log().all()
//                .headers("MyHeader", "Something", "MyOtherHeader", "SomethingElse")
//                .when().get("/study");

//        Map<String, Object> headerMap = new HashMap<>();
//        headerMap.put("MapHeader", "Something");
//        headerMap.put("MapOtherHeader", "SomethingElse");
//
//        RestAssured.given().log().all()
//                .headers(headerMap)
//                .when().get("/study");
//
//        // Content type
//        RestAssured.given().log().all()
//                .contentType(ContentType.JSON)
//                .when().get("/study");
//
//        RestAssured.given().log().all()
//                .contentType("application/json")
//                .when().get("/study");
//
        // Request Body
//        RestAssured.given().log().all()
//                .contentType("application/json")
//                .body("some body")
//                .when().put("/study"); // POST, PUT, DELETE에 사용한다.

//        BodyParam bodyParam = new BodyParam();
//        bodyParam.setName("loop");
//        bodyParam.setValue("study");
//
//        RestAssured.given().log().all()
//                .body(bodyParam)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .when().put("/study"); // POST, PUT, DELETE에 사용한다.
//
//        Map<String, Object> bodyMap = new HashMap<>();
//        bodyMap.put("mapName", "loop");
//        bodyMap.put("mapValue", "study");
//
//        RestAssured.given().log().all()
//                .body(bodyMap)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .when().put("/study"); // POST, PUT, DELETE에 사용한다.

//        // Authentication
//        // 유저 생성 과정은 생략한다
//        // - form
//        RestAssured.given().log().all()
//                .auth().form("email@email.com", "q1w2e3r4!", new FormAuthConfig("/login/session", "username", "password"))
//                .when().post("/myinfo");
//
//        // - token
//        Map<String, String> params = new HashMap<>();
//        params.put("email", "email@email.com");
//        params.put("password", "q1w2e3r4!");
//
//        ExtractableResponse<Response> response = RestAssured.given().log().all()
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .body(params)
//                .when().post("/login/token")
//                .then().log().all()
//                .statusCode(HttpStatus.OK.value()).extract();
//
//        String accessToken = response.jsonPath().getString("accessToken");
//
//        RestAssured.given().log().all()
//                .auth().oauth2(accessToken)
//                .accept(MediaType.APPLICATION_JSON_VALUE)
//                .when().get("/members/me")
//                .then().log().all()
//                .statusCode(HttpStatus.OK.value())
//                .extract();
    }
}
