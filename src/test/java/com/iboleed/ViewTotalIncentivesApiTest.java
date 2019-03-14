package com.iboleed;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ViweTotalIncebtivesApiTest {

    @Test
    public void viewIncentivesShouldReturnHttpOk() {
        given()
                .body("")
        .when()
                .get("/incentives/total")
        .then()
                .
    }
}
