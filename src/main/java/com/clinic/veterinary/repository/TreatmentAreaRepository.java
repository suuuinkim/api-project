package com.clinic.veterinary.repository;

<<<<<<< HEAD
import com.clinic.veterinary.repository.domain.TreatmentArea;
=======
import com.clinic.veterinary.domain.TreatmentArea;
>>>>>>> 7969dc5c2dc51faef4445082aa3275cedd68e017
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentAreaRepository extends JpaRepository<TreatmentArea, Long> {
//    public TreatmentArea findOne(Long id){
//        return em.find(TreatmentArea.class, id);
//    }
}
