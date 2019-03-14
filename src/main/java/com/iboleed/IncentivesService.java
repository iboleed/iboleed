package com.iboleed;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class IncentivesService {

//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

//    @Autowired
    MemberRepository memberRepository;


    public Integer getTotal(Long memberId) {
         return calcSum(memberRepository.findById(memberId).get().getFitnessData().getDate());

    }

    public Integer getTotal(String lastname) {
         return calcSum(memberRepository.findByLastName(lastname).get(0).getFitnessData().getDate());

    }

    public Integer calcSum(Instant date) {
        return 1;
    }
}
