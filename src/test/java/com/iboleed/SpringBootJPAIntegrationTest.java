package com.iboleed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IboleedApplication.class)
public class SpringBootJPAIntegrationTest {

    @Autowired
    private GenericEntityRepository genericEntityRepository;

//    @Test
//    public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
//        GenericEntity genericEntity = genericEntityRepository.save(new GenericEntity("test"));
//        GenericEntity foundEntity = genericEntityRepository.findOne(genericEntity.getId());
//
//        assertNotNull(foundEntity);
//        assertEquals(genericEntity.getId(), foundEntity.getId());
//    }
}
