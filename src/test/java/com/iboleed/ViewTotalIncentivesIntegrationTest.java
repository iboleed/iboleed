package com.iboleed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ViewTotalIncentivesController.class)
public class ViewTotalIncentivesIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ViewTotalIncentivesService viewTotalIncentivesService;

    @Test
    public void totalIncentivesResponseShouldHaveMediaTypeJson() throws Exception {
        Long memberId = 1L;
        mvc.perform(get("/incentives/total").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .param("memberId", memberId.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void totalCountFromResponseIsANumber() throws Exception {
        mvc.perform(get("/incentives/total").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .param("memberId", "1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("total_points").isNumber());
    }
}
