package com.iboleed;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IboleedApplication.class)
public class IboleedApplicationTests {

	@Before
	public void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8081;
	}

	@Test
	public void contextLoads() {
		assertTrue(true);
	}

	@Test
	public void whenRequestGet_thenOK(){
		when().request("GET", "/iboleed").then().statusCode(200);
	}

	@Test
	public void whenMeasureResponseTime_thenOK() {
		Response response = RestAssured.get("/iboleed/1");
		long timeInMS = response.time();
		long timeInS = response.timeIn(TimeUnit.SECONDS);

		assertEquals(timeInS, timeInMS/1000);
	}

	@Test
	public void whenValidateResponseTime_thenSuccess() {
		when().get("/iboleed/1").then().time(lessThan(5000L));
	}

	@Test
	public void whenValidateResponseTimeInSeconds_thenSuccess(){
		when().get("/iboleed/1").then().time(lessThan(5L), TimeUnit.SECONDS);
	}

}
