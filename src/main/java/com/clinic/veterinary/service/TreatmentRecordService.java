package com.clinic.veterinary.service;

import com.clinic.veterinary.api.DeleteRecordResponse;
import com.clinic.veterinary.api.RecordNotFoundException;
import com.clinic.veterinary.api.dto.TreatmentRecordDto;
import com.clinic.veterinary.domain.*;
import com.clinic.veterinary.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TreatmentRecordService {

    private final TreatmentRecordRepository treatmentRecordRepository;
    private final DoctorRepository doctorRepository;
    private final AnimalRepository animalRepository;
    private final AnimalTypeRepository animalTypeRepository;
    private final TreatmentAreaRepository treatmentAreaRepository;

    private final RecordTreatmentAreaRepository recordTreatmentAreaRepository;

    public TreatmentRecord findOne(Long id){
        return treatmentRecordRepository.findOne(id);
    }

    /**
     * 진료기록 등록
     */
    @Transactional
    public Long treatmentRecord(Long doctorId, Long animalId, Long animalTypeId, String recordContent, List<Long> treatmentAreaIds){
        Doctor doctor = doctorRepository.findOne(doctorId);
        Animal animal = animalRepository.findOne(animalId);
        AnimalType animalType = animalTypeRepository.fineOne(animalTypeId);

        // 진료 등록
        TreatmentRecord treatmentRecord = TreatmentRecord.createTreatmentRecord(doctor, animal, animalType, recordContent);
        treatmentRecordRepository.save(treatmentRecord);

        // RecordTreatmentArea 저장
        for (Long treatmentAreaId : treatmentAreaIds) {
            TreatmentArea treatmentArea = treatmentAreaRepository.findOne(treatmentAreaId);
            RecordTreatmentArea recordTreatmentArea = RecordTreatmentArea.createRecordTreatmentArea(treatmentRecord, treatmentArea);
            recordTreatmentAreaRepository.save(recordTreatmentArea);
        }

        return treatmentRecord.getId();
    }


    /**
     * 진료기록 수정
     */
    @Transactional
    public void update(Long id, String recordContent){
        TreatmentRecord treatmentRecord = treatmentRecordRepository.findOne(id);
        treatmentRecord.setRecordContent(recordContent);
    }

    /**
     * 진료기록 삭제
     */
    @Transactional
    public DeleteRecordResponse delete(Long id){
        TreatmentRecord treatmentRecord = treatmentRecordRepository.findOne(id);

        if(treatmentRecord != null){ // 삭제 성공
            treatmentRecordRepository.delete(treatmentRecord);
            return new DeleteRecordResponse(true, id, "진료기록을 삭제했습니다.");
        }else{ // 삭제 실패
            return new DeleteRecordResponse(false, null, "진료기록을 삭제하지 못했습니다. 확인해주세요.");
        }
    }

    /**
     * 동물 이름을 기반으로 진료 기록 삭제
     */
    public DeleteRecordResponse deleteRecordByAnimalName(String animalName) {
        List<TreatmentRecord> records = treatmentRecordRepository.searchRecords(null, animalName);
        if (records.isEmpty()) {
            throw new RecordNotFoundException(false, "검색결과가 없습니다.");
        }
        for (TreatmentRecord record : records) {
            treatmentRecordRepository.delete(record);
        }
        return new DeleteRecordResponse(true, null, "진료기록을 삭제했습니다.");
    }

//    /**
//     * 진료기록 삭제 by 동물 이름
//     */
//    public DeleteRecordResponse deleteRecordByAnimalName(String animalName) {
////        List<TreatmentRecordDto> records = treatmentRecordRepository.searchRecordsByAnimalName(animalName);
//        List<TreatmentRecordDto> records = treatmentRecordRepository.searchRecords(null, animalName);
//        if (records.isEmpty()) {
//            throw new RecordNotFoundException(false, "검색결과가 없습니다.");
//        }
//        for (TreatmentRecordDto record : records) {
//            treatmentRecordRepository.delete(record);
//        }
//        return new DeleteRecordResponse(true, null, "진료기록을 삭제했습니다.");
//
//    }

//    /**
//     * 진료기록 검색 by 의사이름
//     */
//    public List<TreatmentRecord> searchRecordsByDoctorName(String doctorName) {
//        return treatmentRecordRepository.searchRecordsByDoctorName(doctorName);
//    }
//
//    /**
//     * 진료기록 검색 by 동물이름
//     */
//    public List<TreatmentRecord> searchRecordsByAnimalName(String animalName) {
//        return treatmentRecordRepository.searchRecordsByAnimalName(animalName);
//    }
}
