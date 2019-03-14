package com.iboleed;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class ViewTotalIncentivesUnitTest {

    private ViewTotalIncentivesService service;

    private final Long memberId = 1L;
    @Before
    public void setUp() throws Exception {
        service = new ViewTotalIncentivesService();
    }

    @Test
    public void totalPointsIsNotNegative() {
        Integer totalPoints = service.getTotalPoints(memberId);
        assertTrue(totalPoints >= 0);
    }
}

