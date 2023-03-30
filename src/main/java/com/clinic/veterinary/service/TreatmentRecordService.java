package com.clinic.veterinary.service;

import com.clinic.veterinary.api.DeleteRecordResponse;
import com.clinic.veterinary.domain.*;
import com.clinic.veterinary.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    public Long treatmentRecord(Long doctorId, Long animalId, Long animalTypeId,  String recordContent){

        Doctor doctor = doctorRepository.findOne(doctorId);
        Animal animal = animalRepository.findOne(animalId);
        AnimalType animalType = animalTypeRepository.fineOne(animalTypeId);

        // 진료 등록
        TreatmentRecord treatmentRecord = TreatmentRecord.createTreatmentRecord(doctor, animal, animalType, recordContent);
        treatmentRecordRepository.save(treatmentRecord);

        return treatmentRecord.getId();
    }

    @Transactional
    public Long createRecordTreatmentArea(Long treatmentRecordId, Long treatmentAreaId) {
        TreatmentRecord treatmentRecord = treatmentRecordRepository.findOne(treatmentRecordId);
        TreatmentArea treatmentArea = treatmentAreaRepository.findOne(treatmentAreaId);

        RecordTreatmentArea recordTreatmentArea = RecordTreatmentArea.createRecordTreatmentArea(treatmentRecord, treatmentArea);
        recordTreatmentAreaRepository.save(recordTreatmentArea);
        return recordTreatmentArea.getId();
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
            return new DeleteRecordResponse(id, true);
        }else{ // 삭제 실패
            return new DeleteRecordResponse(null, false);
        }
    }

}
