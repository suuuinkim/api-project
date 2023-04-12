package com.clinic.veterinary.repository;

import com.clinic.veterinary.repository.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
//    public Doctor findOne(Long id){
//        return em.find(Doctor.class, id);
//    }
}
