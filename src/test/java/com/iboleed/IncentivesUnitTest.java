package com.iboleed;

import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class IncentivesUnitTest {

    private IncentivesService incentivesService;
    Member mb = new Member( "Member", "Tim Schimandle", "qwerty","", new FitnessData());

    @Before
    public void before (){
        MemberRepository memberRepository = mock(MemberRepository.class);
        incentivesService = new IncentivesService(memberRepository);

//        doReturn(Optional.of(mb)).when(memberRepository).findById(22l);
        when(memberRepository.findById(22l)).thenReturn(Optional.of(mb));
    }


    @Test
    public void shouldShowTotalIncentivesFromService(){
        assertEquals(incentivesService.getTotal(22l),new Integer(1));
    }

    @Test
    public void shouldTotalIncentivesShowSumOfDailyPoints(){
        Integer dt  = incentivesService.calcSum(Instant.now());

        assertNotNull(dt);
        assertEquals(dt, new Integer(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowException(){
        incentivesService.getTotal(0l);
    }

}