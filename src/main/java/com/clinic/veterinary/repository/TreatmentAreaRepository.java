package com.clinic.veterinary.repository;

import com.clinic.veterinary.domain.TreatmentArea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentAreaRepository extends JpaRepository<TreatmentArea, Long> {
}
