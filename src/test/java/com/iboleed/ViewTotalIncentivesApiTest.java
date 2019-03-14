package com.iboleed;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
public class ViewTotalIncentivesApiTest {

    @Test()
    public void viewIncentivesShouldReturnHttpOk() {
        given()
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .param("memberId", 1)
                .body("")
        .when()
                .get("/incentives/total")
        .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
