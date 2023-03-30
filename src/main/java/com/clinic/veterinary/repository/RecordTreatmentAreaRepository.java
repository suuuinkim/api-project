package com.clinic.veterinary.repository;

import com.clinic.veterinary.domain.RecordTreatmentArea;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class RecordTreatmentAreaRepository {
    private final EntityManager em;

    public RecordTreatmentArea findOne(Long id){
        return em.find(RecordTreatmentArea.class, id);
    }

    public void save(RecordTreatmentArea recordTreatmentArea){
        em.persist(recordTreatmentArea);
    }
}
