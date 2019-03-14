package com.iboleed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        Member alex = new Member("1","ddd","gg", "-90","");
        entityManager.merge(alex);
        entityManager.persist(alex);

        entityManager.flush();

        // when
        Member found = memberRepository.findByName(alex.getFirstName());

//        memberRepository.save(new Member());
//        memberRepository.findByName(found.getLastName());

        // then
        assertNotNull(found);
        assertEquals(found.getId(),"1");

        //        assertThat(found.getFirstName())
//                .isEqualTo(alex.getFirstName());
    }

}