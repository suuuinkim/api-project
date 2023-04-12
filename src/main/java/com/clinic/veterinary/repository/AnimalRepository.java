package com.clinic.veterinary.repository;

import com.clinic.veterinary.repository.domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
//    public Animal findOne(Long id){
//        return em.find(Animal.class, id);
//    }
}
