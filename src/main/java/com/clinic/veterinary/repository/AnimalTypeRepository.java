package com.clinic.veterinary.repository;


import com.clinic.veterinary.domain.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalTypeRepository extends JpaRepository<AnimalType, Long> {

}
