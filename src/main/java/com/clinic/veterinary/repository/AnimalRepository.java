package com.clinic.veterinary.repository;

import com.clinic.veterinary.domain.Animal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class AnimalRepository {

    private final EntityManager em;

    public Animal findOne(Long id){
        return em.find(Animal.class, id);
    }
}
