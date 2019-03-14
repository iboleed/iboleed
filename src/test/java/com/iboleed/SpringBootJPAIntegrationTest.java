package com.iboleed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SpringBootJPAIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Member alex = new Member("ddd","gg", "-90", "nnnn");

        entityManager.persist(alex);

        entityManager.flush();

        // when
        memberRepository.save(alex);
        List<Member> found = memberRepository.findByLastName(alex.getLastName());

        // then
        assertNotNull(found);
        assertEquals(found.get(0).getFirstName(),"ddd");

        //        assertThat(found.getFirstName())
//                .isEqualTo(alex.getFirstName());
    }

}