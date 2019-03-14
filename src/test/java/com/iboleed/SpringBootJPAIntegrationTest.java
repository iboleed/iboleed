package com.iboleed;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SpringBootJPAIntegrationTest {


    @Autowired
    private MemberRepository memberRepository;

    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8081;
        Member alex = new Member("Tim","Schimandle", "-90", "nnnn", new FitnessData());
        Member alex2 = new Member("John","Slavisa", "-90", "nnnn", new FitnessData());
        memberRepository.save(alex);
        memberRepository.save(alex2);
    }


    @Test
    public void whenFindByName_thenReturnEmployee() {
        List<Member> found = memberRepository.findByLastName("ddd");
        assertNotNull(found);
        assertEquals(found.get(0).getFirstName(),"ddd");
    }

    @Test
    public void shouldPass1000Steps(){

    }
///
    @Test
    public void shouldShowTotalIncentives(){
        when().request("GET", "/iboleed/totalincentives/Slavisa").then().statusCode(200);
    }
///
    @Test
    public void shouldViewFitnessData(){

    }

    @Test
    public void shouldReturnMyRating(){

    }

    @Test
    public void calculateMyRating(){}

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