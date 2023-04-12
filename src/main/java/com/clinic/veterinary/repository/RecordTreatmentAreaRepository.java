package com.clinic.veterinary.repository;

import com.clinic.veterinary.repository.domain.RecordTreatmentArea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordTreatmentAreaRepository extends JpaRepository<RecordTreatmentArea, Long> {
//    public RecordTreatmentArea findOne(Long id){
//        return em.find(RecordTreatmentArea.class, id);
//    }
//    public void save(RecordTreatmentArea recordTreatmentArea){
//        em.persist(recordTreatmentArea);
//    }
}
