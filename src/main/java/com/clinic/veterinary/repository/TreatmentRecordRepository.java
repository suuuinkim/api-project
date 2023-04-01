package com.clinic.veterinary.repository;

import com.clinic.veterinary.api.dto.TreatmentRecordDto;
import com.clinic.veterinary.domain.*;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TreatmentRecordRepository {
   // private final JPAQueryFactory queryFactory;
   private final EntityManager em;

    /**
     * Querydsl
     */
    private final QTreatmentRecord qTreatmentRecord = QTreatmentRecord.treatmentRecord;
    private final QDoctor qDoctor = QDoctor.doctor;

    private JPAQueryFactory queryFactory() {
        return new JPAQueryFactory(em);
    }

    public List<TreatmentRecord> searchRecords(String doctorName, String animalName) {
        QTreatmentRecord qTreatmentRecord = QTreatmentRecord.treatmentRecord;
        QDoctor qDoctor = QDoctor.doctor;
        QAnimal qAnimal = QAnimal.animal;
        BooleanBuilder builder = new BooleanBuilder();

        if (doctorName != null) {
            builder.and(qDoctor.name.eq(doctorName));
        }
        if (animalName != null) {
            builder.and(qAnimal.name.eq(animalName));
        }

        return queryFactory().selectFrom(qTreatmentRecord)
                .join(qTreatmentRecord.doctor, qDoctor)
                .join(qTreatmentRecord.animal, qAnimal)
                .where(builder)
                .fetch();
    }

//    public List<TreatmentRecord> searchRecords(String doctorName, String animalName) {
//        QTreatmentRecord qTreatmentRecord = QTreatmentRecord.treatmentRecord;
//        QDoctor qDoctor = QDoctor.doctor;
//        QAnimal qAnimal = QAnimal.animal;
//        QAnimalType qAnimalType = QAnimalType.animalType;
//        BooleanBuilder builder = new BooleanBuilder();
//
//        if (doctorName != null) {
//            builder.and(qDoctor.name.eq(doctorName));
//        }
//        if (animalName != null) {
//            builder.and(qAnimal.name.eq(animalName));
//        }
//
//        return queryFactory().select(
//                        Projections.constructor(TreatmentRecordDto.class,
//                                qTreatmentRecord.id, qDoctor.name, qAnimal.name, qAnimalType.name,
//                                qTreatmentRecord.recordTreatmentAreas, qTreatmentRecord.recordDate, qTreatmentRecord.recordContent,
//                                qAnimalType.animalTypeTreatmentAreas
//                        ))
//                .from(qTreatmentRecord)
//                .join(qTreatmentRecord.doctor, qDoctor)
//                .join(qTreatmentRecord.animal, qAnimal)
//                .join(qTreatmentRecord.animalType, qAnimalType)
//                .where(builder)
//                .fetch();
//    }

//    /**
//     * 진료기록 검색 by 의사이름
//     */
//    public List<TreatmentRecordDto> searchRecordsByDoctorName(String doctorName) {
//        QTreatmentRecord qTreatmentRecord = QTreatmentRecord.treatmentRecord;
//        QDoctor qDoctor = QDoctor.doctor;
//        BooleanBuilder builder = new BooleanBuilder();
//
//        if (doctorName != null) {
//            builder.and(qDoctor.name.eq(doctorName));
//        }
//
//        return queryFactory().select(
//                        Projections.constructor(TreatmentRecordDto.class,
//                                qTreatmentRecord.id, qTreatmentRecord.animal.name,
//                                qTreatmentRecord.doctor.name, qTreatmentRecord.recordDate
//                                ))
//                .from(qTreatmentRecord)
//                .join(qTreatmentRecord.doctor, qDoctor)
//                .where(builder)
//                .fetch();
//    }
//
//    /**
//     * 진료기록 검색 by 동물이름
//     */
//    public List<TreatmentRecordDto> searchRecordsByAnimalName(String animalName) {
//        QTreatmentRecord qTreatmentRecord = QTreatmentRecord.treatmentRecord;
//        QAnimal qAnimal = QAnimal.animal;
//        BooleanBuilder builder = new BooleanBuilder();
//
//        if (animalName != null) {
//            builder.and(qAnimal.name.eq(animalName));
//        }
//
//        return queryFactory().select(
//                        Projections.constructor(TreatmentRecordDto.class,
//                                qTreatmentRecord.id, qTreatmentRecord.animal.name,
//                                qTreatmentRecord.doctor.name, qTreatmentRecord.recordDate
//                        ))
//                .from(qTreatmentRecord)
//                .join(qTreatmentRecord.animal, qAnimal)
//                .where(builder)
//                .fetch();
//    }

//    public List<TreatmentRecord> searchRecordsByDoctorNameOrAnimalName(String name) {
//
//        BooleanExpression doctorNameEq = qDoctor.name.eq(name);
//        BooleanExpression animalNameEq = qTreatmentRecord.animal.name.eq(name);
//        return queryFactory().selectFrom(qTreatmentRecord)
//                .leftJoin(qTreatmentRecord.doctor, qDoctor)
//                .leftJoin(qTreatmentRecord.animal)
//                .where(doctorNameEq.or(animalNameEq))
//                .fetch();
//
//        return queryFactory().selectFrom(qTreatmentRecord)
//                .join(qTreatmentRecord.doctor, qDoctor)
//                .where(qDoctor.name.eq(doctorName))
//                .fetch();
//    }

    public List<TreatmentRecord> findAllRecord() {
        return em.createQuery(
                "select r from TreatmentRecord r" +
                        " join fetch r.doctor d" +
                        " join fetch r.animal a" +
                        " join fetch r.animalType at"
        ).getResultList();
    }

    public void save(TreatmentRecord treatmentRecord) {
        em.persist(treatmentRecord);
    }

    public TreatmentRecord findOne(Long id) {
        return em.find(TreatmentRecord.class, id);
    }


//    public void delete(TreatmentRecordDto treatmentRecord) {
//        em.remove(treatmentRecord);
//    }

    public void delete(TreatmentRecord treatmentRecord) {
        em.remove(treatmentRecord);
    }


}
