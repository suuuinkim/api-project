package com.clinic.veterinary.service;

import com.clinic.veterinary.domain.*;
import com.clinic.veterinary.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


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

    public Optional<TreatmentRecord> findOne(Long id){
        return treatmentRecordRepository.findById(id);
    }

    /**
     * 진료기록 등록
     */
    @Transactional
    public Long treatmentRecord(Long doctorId, Long animalId, Long animalTypeId, String recordContent, List<Long> treatmentAreaIds){
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        Optional<Animal> animal = animalRepository.findById(animalId);
        Optional<AnimalType> animalType = animalTypeRepository.findById(animalTypeId);

        // 진료 등록
        TreatmentRecord treatmentRecord = TreatmentRecord.createTreatmentRecord(doctor.get(), animal.get(), animalType.get(), recordContent);
        treatmentRecordRepository.save(treatmentRecord);

        // RecordTreatmentArea 저장
        for (Long treatmentAreaId : treatmentAreaIds) {
            Optional<TreatmentArea> treatmentArea = treatmentAreaRepository.findById(treatmentAreaId);
            RecordTreatmentArea recordTreatmentArea = RecordTreatmentArea.createRecordTreatmentArea(treatmentRecord, treatmentArea.get());
            recordTreatmentAreaRepository.save(recordTreatmentArea);
        }

        return treatmentRecord.getId();
    }


    /**
     * 진료기록 수정
     */
    @Transactional
    public void update(Long id, String recordContent){
        Optional<TreatmentRecord> treatmentRecord = treatmentRecordRepository.findById(id);
        treatmentRecord.get().setRecordContent(recordContent);
    }

    /**
     * 진료기록 삭제
     */

    @Transactional
    public void delete(Long id){
        Optional<TreatmentRecord> treatmentRecord = treatmentRecordRepository.findById(id);
        treatmentRecordRepository.deleteById(treatmentRecord.get().getId());
    }


}
