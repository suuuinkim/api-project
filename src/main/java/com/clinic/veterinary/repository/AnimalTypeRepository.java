package com.clinic.veterinary.repository;

<<<<<<< HEAD
import com.clinic.veterinary.repository.domain.AnimalType;
=======
import com.clinic.veterinary.domain.AnimalType;
>>>>>>> 7969dc5c2dc51faef4445082aa3275cedd68e017
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalTypeRepository extends JpaRepository<AnimalType, Long> {

//    public AnimalType fineOne(Long id){
//        return em.find(AnimalType.class, id);
//    }
}
