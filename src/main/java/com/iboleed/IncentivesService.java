package com.iboleed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class IncentivesService {

    @Autowired
    MemberRepository memberRepository;


    public Integer getTotal(Long memberId) {
        Optional<Instant> instant = memberRepository.findById(memberId)
                .map(member -> member.getFitnessData().getDate());
        if (instant.isPresent()) {
            return calcSum(instant.get());
        }
        return 0;
    }

    public Integer calcSum(Instant date) {
        return 222;
    }
}
