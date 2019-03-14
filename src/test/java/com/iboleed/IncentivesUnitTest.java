package com.iboleed;

import net.bytebuddy.asm.Advice;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class IncentivesUnitTest {


    MemberRepository memberRepository = mock(MemberRepository.class);

//    MemberRepository memberRepository = new MemberRepository() {
//        @Override
//        public List<Member> findByLastName(String lastName) {
//            return null;
//        }
//
//        @Override
//        public <S extends Member> S save(S entity) {
//            return null;
//        }
//
//        @Override
//        public <S extends Member> Iterable<S> saveAll(Iterable<S> entities) {
//            return null;
//        }
//
//        @Override
//        public Optional<Member> findById(Long aLong) {
//            return Optional.empty();
//        }
//
//        @Override
//        public boolean existsById(Long aLong) {
//            return false;
//        }
//
//        @Override
//        public Iterable<Member> findAll() {
//            return null;
//        }
//
//        @Override
//        public Iterable<Member> findAllById(Iterable<Long> longs) {
//            return null;
//        }
//
//        @Override
//        public long count() {
//            return 0;
//        }
//
//        @Override
//        public void deleteById(Long aLong) {
//
//        }
//
//        @Override
//        public void delete(Member entity) {
//
//        }
//
//        @Override
//        public void deleteAll(Iterable<? extends Member> entities) {
//
//        }
//
//        @Override
//        public void deleteAll() {
//
//        }
//    };

        Member mb = new Member( "Member", "Tim Schimandle", "qwerty","", new FitnessData());

    @Before
    public void before (){
        doReturn(Optional.of(mb)).when(memberRepository).findById(22l);
//        when(memberRepository.findById(22l)).thenReturn(Optional.of(mb));
    }


    @Test
    public void shouldShowTotalIncentivesFromService(){
        assertEquals(new IncentivesService().getTotal(22l),new Integer(1));
    }

    @Test
    public void shouldTotalIncentivesShowSumOfDailyPoints(){
        Integer dt  = new IncentivesService().calcSum(Instant.now());

        assertNotNull(dt);
        assertEquals(dt, new Integer(222));
    }

}