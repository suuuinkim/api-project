package com.clinic.veterinary.repository;

import com.clinic.veterinary.domain.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class DoctorRepository {
    private final EntityManager em;
    public Doctor findOne(Long id){
        return em.find(Doctor.class, id);
    }
}
