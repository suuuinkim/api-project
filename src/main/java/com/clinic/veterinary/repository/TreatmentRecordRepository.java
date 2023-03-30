package com.clinic.veterinary.repository;

import com.clinic.veterinary.domain.QDoctor;
import com.clinic.veterinary.domain.QTreatmentRecord;
import com.clinic.veterinary.domain.TreatmentRecord;
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

    public List<TreatmentRecord> searchRecordsByDoctorName(String doctorName) {
        return queryFactory().selectFrom(qTreatmentRecord)
                .join(qTreatmentRecord.doctor, qDoctor)
                .where(qDoctor.name.eq(doctorName))
                .fetch();
    }

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


    public void delete(TreatmentRecord treatmentRecord) {
        em.remove(treatmentRecord);
    }



}
