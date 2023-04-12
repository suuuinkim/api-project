package com.clinic.veterinary.repository;


import com.clinic.veterinary.domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
