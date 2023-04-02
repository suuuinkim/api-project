package com.clinic.veterinary.repository;

import com.clinic.veterinary.domain.AnimalType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class AnimalTypeRepository {
    private final EntityManager em;

    public AnimalType fineOne(Long id){
        return em.find(AnimalType.class, id);
    }
}
