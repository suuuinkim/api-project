package com.clinic.veterinary.repository;

<<<<<<< HEAD
import com.clinic.veterinary.repository.domain.RecordTreatmentArea;
=======
import com.clinic.veterinary.domain.RecordTreatmentArea;
>>>>>>> 7969dc5c2dc51faef4445082aa3275cedd68e017
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordTreatmentAreaRepository extends JpaRepository<RecordTreatmentArea, Long> {
//    public RecordTreatmentArea findOne(Long id){
//        return em.find(RecordTreatmentArea.class, id);
//    }
//    public void save(RecordTreatmentArea recordTreatmentArea){
//        em.persist(recordTreatmentArea);
//    }
}
