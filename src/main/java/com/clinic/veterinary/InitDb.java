//package com.clinic.veterinary;
//
//import com.clinic.veterinary.domain.*;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.PostConstruct;
//import javax.persistence.EntityManager;
//
//@Component
//@RequiredArgsConstructor
//public class InitDb {
//    private final InitService initService;
//
//    @PostConstruct
//    public void init(){
//        initService.dbInit1();
//    }
//
//    @Component
//    @Transactional
//    @RequiredArgsConstructor
//    static class InitService{
//        private final EntityManager em;
//
//        public void dbInit1(){
//            // 의사 데이터
//            Doctor doctor1 = createDoctor("김박사");
//            em.persist(doctor1);
//
//            Doctor doctor2 = createDoctor("하박사");
//            em.persist(doctor2);
//
////            User user1 = createUser("user01", "김박사", "$2a$10$wjG4OvJue6B1Hr2aJF7uhuVtmlH6jvegvpRURkGYGAyxI1PXK8sWa", "test@gmail.com", Role.USER, doctor1);
//            Member member1 = createUser("user01", "김박사", "$2a$10$wjG4OvJue6B1Hr2aJF7uhuVtmlH6jvegvpRURkGYGAyxI1PXK8sWa", "test@gmail.com", Role.USER, doctor1);
//            em.persist(member1);
//
//            // 동물 타입 데이터
//            AnimalType animalType1 = createAnimalType("강아지");
//            em.persist(animalType1);
//            AnimalType animalType2 = createAnimalType("고양이");
//            em.persist(animalType2);
//            AnimalType animalType3 = createAnimalType("조류");
//            em.persist(animalType3);
//            AnimalType animalType4 = createAnimalType("파충류");
//            em.persist(animalType4);
//
//            // 동물 데이터
//            Animal animal1 = Animal.createAnimal(animalType1, "백구");
//            em.persist(animal1);
//            Animal animal2 = Animal.createAnimal(animalType2, "나비");
//            em.persist(animal2);
//
//            // 동물 종류별 진료 부위
//            AnimalTypeTreatmentArea animalTypeTreatmentArea1 = AnimalTypeTreatmentArea.createAnimalTypeTreatmentArea(animalType1,  "초음파");
//            em.persist(animalTypeTreatmentArea1);
//            AnimalTypeTreatmentArea animalTypeTreatmentArea2 = AnimalTypeTreatmentArea.createAnimalTypeTreatmentArea(animalType2,  "구강검사");
//            em.persist(animalTypeTreatmentArea2);
//
//            // 공통 진료 부위 데이터
//            TreatmentArea treatmentArea1 = TreatmentArea.createTreatmentArea("백신접종");
//            em.persist(treatmentArea1);
//            TreatmentArea treatmentArea2 = TreatmentArea.createTreatmentArea("중성화");
//            em.persist(treatmentArea2);
//
//
//            // 진료 기록
//            TreatmentRecord treatmentRecord1 = TreatmentRecord.createTreatmentRecord(doctor1, animal1, animalType1, "양호합니다");
//            em.persist(treatmentRecord1);
//
//            RecordTreatmentArea recordTreatmentArea1 = RecordTreatmentArea.createRecordTreatmentArea(treatmentRecord1, treatmentArea1);
//            em.persist(recordTreatmentArea1);
//
//
//        }
//
//
//
//        private static Doctor createDoctor(String name) {
//            Doctor doctor = new Doctor();
//            doctor.setName(name);
//            return doctor;
//        }
//
//        private static Member createUser(String loginId, String username, String password, String email, Role role, Doctor doctor){
//            Member member = new Member(loginId, username, password, email, role, doctor);
//
//            return member;
//        }
//
//        private static AnimalType createAnimalType(String name) {
//            AnimalType animalType = new AnimalType();
//            animalType.setName(name);
//            return animalType;
//        }
//
//
//
//
//    }
//}
