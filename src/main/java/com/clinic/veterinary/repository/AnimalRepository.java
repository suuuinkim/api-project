package com.clinic.veterinary.repository;

<<<<<<< HEAD
import com.clinic.veterinary.repository.domain.Animal;
=======
import com.clinic.veterinary.domain.Animal;
>>>>>>> 7969dc5c2dc51faef4445082aa3275cedd68e017
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
//    public Animal findOne(Long id){
//        return em.find(Animal.class, id);
//    }
}
