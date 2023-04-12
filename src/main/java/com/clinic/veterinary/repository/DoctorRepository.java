package com.clinic.veterinary.repository;

<<<<<<< HEAD
import com.clinic.veterinary.repository.domain.Doctor;
=======
import com.clinic.veterinary.domain.Doctor;
>>>>>>> 7969dc5c2dc51faef4445082aa3275cedd68e017
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
//    public Doctor findOne(Long id){
//        return em.find(Doctor.class, id);
//    }
}
