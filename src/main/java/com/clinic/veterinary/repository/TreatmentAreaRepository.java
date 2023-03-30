package com.clinic.veterinary.repository;

import com.clinic.veterinary.domain.TreatmentArea;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class TreatmentAreaRepository {
    private final EntityManager em;

    public TreatmentArea findOne(Long id){
        return em.find(TreatmentArea.class, id);
    }
}
