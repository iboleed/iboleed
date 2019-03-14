package com.iboleed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/iboleed")
public class ViewTotalIncentivesController {

    @Autowired
    private ViewTotalIncentivesService viewTotalIncentivesService;
    @Autowired
    private IncentivesService incentivesService;


    @GetMapping(value = "/incentives/total",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getTotalIncentieves(@RequestParam Long memberId) {
        return "{\"total_points\": " + viewTotalIncentivesService.getTotalPoints(memberId) + "}";
    }

    @GetMapping("")
    public List<Member> findAllMem() {
        return memberListt;
    }

    @GetMapping("/totalincentives/{lastname}")
    public Integer findTotalIncentives(@PathVariable String lastname) {
        return incentivesService.getTotal(lastname);
    }

    @GetMapping("/{memId}")
    public Member findMem(@PathVariable Long bookId) {
        return memberListt.stream().filter(b -> b.getFirstName().equals(bookId)).findFirst().orElse(null);
    }



    //	//Template
    private List<Member> memberListt = Arrays.asList(
            new Member( "Member", "Tim Schimandle", "qwerty","", new FitnessData()),
            new Member( "Member2", "Slavisa", "asdf","", new FitnessData())
    );

    //Template
    private List<FitnessData> fitnessData = Arrays.asList(
            new FitnessData.FitnessDataBuilder()
//					.memberId("22")
                    .date(Instant.now())
                    .steps(123)
                    .build(),
            new FitnessData.FitnessDataBuilder()
//					.memberId("46")
                    .date(Instant.now())
                    .steps(34)
                    .build()

    );

}
