package com.cho.ecommerce.common;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;


//This allows multiple tests to be run concurrently, as each test will use a different port to avoid conflicts.
//It also allows tests to be run in parallel on different machines

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class SeparationOfPortToAvoidConflict {
    @LocalServerPort
    int port;

    @BeforeEach
    public void setup(){
        RestAssured.port = port;
    }
}
