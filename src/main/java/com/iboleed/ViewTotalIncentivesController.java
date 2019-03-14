package com.iboleed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewTotalIncentivesController {

    @Autowired
    private ViewTotalIncentivesService viewTotalIncentivesService;

    @GetMapping(value = "/incentives/total",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getTotalIncentieves(@RequestParam Long memberId) {
        return "{\"total_points\": " + viewTotalIncentivesService.getTotalPoints(memberId) + "}";
    }
}
