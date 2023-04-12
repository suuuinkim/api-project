package com.clinic.veterinary.repository;

import com.clinic.veterinary.domain.*;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

import static com.clinic.veterinary.domain.QTreatmentRecord.treatmentRecord;
import static org.springframework.util.StringUtils.hasText;

public class TreatmentRecordRepositoryImpl implements TreatmentRecordRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public TreatmentRecordRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    private final QTreatmentRecord qTreatmentRecord = treatmentRecord;
    private final QDoctor qDoctor = QDoctor.doctor;


    @Override
    public List<TreatmentRecord> search(RecordSearchCondition condition) {
        QTreatmentRecord qTreatmentRecord = treatmentRecord;
        QDoctor qDoctor = QDoctor.doctor;
        QAnimal qAnimal = QAnimal.animal;
        BooleanBuilder builder = new BooleanBuilder();

        if (condition.getDoctorName() != null) {
            builder.and(qDoctor.name.eq(condition.getDoctorName()));
        }
        if (condition.getAnimalName() != null) {
            builder.and(qAnimal.name.eq(condition.getAnimalName()));
        }

        return queryFactory.selectFrom(qTreatmentRecord)
                .join(qTreatmentRecord.doctor, qDoctor)
                .join(qTreatmentRecord.animal, qAnimal)
                .where(builder)
                .fetch();
    }



    private BooleanExpression doctorNameEq(String doctorName) {
        return hasText(doctorName) ? treatmentRecord.doctor.name.eq(doctorName) : null;
    }

    private BooleanExpression animalNameEq(String animalName) {
        return hasText(animalName) ? treatmentRecord.animal.name.eq(animalName) : null;
    }
}
