package com.clinic.veterinary.repository;

<<<<<<< HEAD
import com.clinic.veterinary.repository.domain.TreatmentRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRecordRepository extends JpaRepository<TreatmentRecord, Long>, TreatmentRecordRepositoryCustom {
=======
import com.clinic.veterinary.domain.TreatmentRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRecordRepository extends JpaRepository<TreatmentRecord, Long> {

    /**
     * Querydsl
     */
//    private final QTreatmentRecord qTreatmentRecord = QTreatmentRecord.treatmentRecord;
//    private final QDoctor qDoctor = QDoctor.doctor;

//    private JPAQueryFactory queryFactory() {
//        return new JPAQueryFactory(em);
//    }

//    public List<TreatmentRecord> searchRecords(String doctorName, String animalName) {
//        QTreatmentRecord qTreatmentRecord = QTreatmentRecord.treatmentRecord;
//        QDoctor qDoctor = QDoctor.doctor;
//        QAnimal qAnimal = QAnimal.animal;
//        BooleanBuilder builder = new BooleanBuilder();
//
//        if (doctorName != null) {
//            builder.and(qDoctor.name.eq(doctorName));
//        }
//        if (animalName != null) {
//            builder.and(qAnimal.name.eq(animalName));
//        }
//
//        return queryFactory().selectFrom(qTreatmentRecord)
//                .join(qTreatmentRecord.doctor, qDoctor)
//                .join(qTreatmentRecord.animal, qAnimal)
//                .where(builder)
//                .fetch();
//    }
//
//    public List<TreatmentRecord> findAllRecord() {
//        return em.createQuery(
//                "select r from TreatmentRecord r" +
//                        " join fetch r.doctor d" +
//                        " join fetch r.animal a"
//        ).getResultList();
//    }
//
//    public void save(TreatmentRecord treatmentRecord) {
//        em.persist(treatmentRecord);
//    }
//
//    public TreatmentRecord findOne(Long id) {
//        return em.find(TreatmentRecord.class, id);
//    }
//
//    public void delete(TreatmentRecord treatmentRecord) {
//        em.remove(treatmentRecord);
//    }
>>>>>>> 7969dc5c2dc51faef4445082aa3275cedd68e017


}
