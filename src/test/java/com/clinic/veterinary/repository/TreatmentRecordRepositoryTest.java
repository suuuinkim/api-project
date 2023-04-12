package com.clinic.veterinary.repository;

import com.clinic.veterinary.domain.TreatmentRecord;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
@Transactional
@Rollback(false)
public class TreatmentRecordRepositoryTest {

    @Autowired
    EntityManager em;
    @Autowired
    TreatmentRecordRepository treatmentRecordRepository;

    JPAQueryFactory queryFactory;


    @Test
    public void findAll() throws Exception{

        List<TreatmentRecord> all = treatmentRecordRepository.findAll();

        Assertions.assertThat(all.size()).isEqualTo(1);

    }
}
