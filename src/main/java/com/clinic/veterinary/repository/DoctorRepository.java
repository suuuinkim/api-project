package com.clinic.veterinary.repository;

import com.clinic.veterinary.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
