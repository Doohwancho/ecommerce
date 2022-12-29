package com.cho.ecommerce.common;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.config.EncoderConfig.encoderConfig;

//use for MockTest

//random ports allows
//  1. multiple tests to be run concurrently, as each test will use a different port to avoid conflicts.
//  2. It also allows tests to be run in parallel on different machines
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class BaseControllerTest {
    @LocalServerPort
    int port;

    final String baseURI = "http://localhost";

    @BeforeEach
    public void setup(){
        RestAssured.port = port;
        RestAssured.baseURI = baseURI;
        RestAssured.config = new RestAssuredConfig().encoderConfig(encoderConfig().defaultContentCharset("UTF-8"));
    }
}
