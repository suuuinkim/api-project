package com.clinic.veterinary.api;

import com.clinic.veterinary.api.dto.TreatmentRecordDto;
import com.clinic.veterinary.domain.TreatmentRecord;
import com.clinic.veterinary.repository.TreatmentRecordRepository;
import com.clinic.veterinary.service.TreatmentRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RecordApiController {
    private final TreatmentRecordService treatmentRecordService;
    private final TreatmentRecordRepository treatmentRecordRepository;

    /**
     * 진료기록 조회
     */
    @GetMapping("/api/v1/records")
    public List<TreatmentRecordDto> recordsV1(){
        List<TreatmentRecord> records = treatmentRecordRepository.findAllRecord();

        List<TreatmentRecordDto> collect = records.stream()
                .map(r -> new TreatmentRecordDto(r))
                .collect(Collectors.toList());

        return collect;
    }


    /**
     * 진료기록 저장
     */
    @PostMapping("/api/v1/record")
    public CreateRecordResponse saveRecordV1(@RequestBody @Valid CreateRecordRequest request){

        try{
            Long id = treatmentRecordService.treatmentRecord(request.getDoctorId(), request.getAnimalId(),
                    request.getAnimalTypeId(), request.getRecordContent(), request.getTreatmentAreaIds());

            return new CreateRecordResponse(true, id, "진료기록을 저장하였습니다.");

        }catch (Exception ex){
            return new CreateRecordResponse(false, null, "진료기록을 저장하는데 실패했습니다. 확인해주세요.");

        }
    }


    /**
     * 진료기록 수정
     */
    @PutMapping("/api/v1/record/{id}")
    public UpdateRecordResponse updateRecordV1(@PathVariable("id") Long id, @RequestBody @Valid UpdateRecordRequest request){

        try{
            treatmentRecordService.update(id, request.getRecordContent());
            TreatmentRecord findRecord = treatmentRecordService.findOne(id);

            return new UpdateRecordResponse(true, findRecord.getId(), "진료기록을 수정하였습니다.");
        }catch (Exception ex){
            return new UpdateRecordResponse(false, null, "진료기록을 수정하는데 실패했습니다. 확인해주세요.");
        }
    }

    /**
     * 진료기록 삭제
     */
    @DeleteMapping("/api/v1/record/{id}")
    public DeleteRecordResponse deleteRecordV1(@PathVariable("id") Long id){
        return treatmentRecordService.delete(id);
    }


    /**
     * 진료기록 삭제 by 동물 이름
     */
    @DeleteMapping("/api/v1/record/deleteByAnimal")
    public DeleteRecordResponse deleteRecordsByAnimalName(@RequestParam String animalName) {
        return treatmentRecordService.deleteRecordByAnimalName(animalName);
    }


    /**
     * 진료기록 검색
     */
    @GetMapping("/api/v1/record/searchRecord")
    public List<TreatmentRecordDto> searchRecords(@RequestParam String doctorName, String animalName){
        return treatmentRecordRepository.searchRecords(doctorName, animalName);
    }

//    /**
//     * 진료기록 검색 by 의사이름
//     */
//    @GetMapping("/api/v1/record/searchByDoctor")
//    public List<TreatmentRecordDto> searchRecordsByDoctorName(@RequestParam String doctorName){
//        return treatmentRecordRepository.searchRecordsByDoctorName(doctorName);
//    }
//
//
//    /**
//     * 진료기록 검색 by 동물이름
//     */
//    @GetMapping("/api/v1/record/searchByAnimal")
//    public List<TreatmentRecordDto> searchRecordsByAnimalName(@RequestParam String animalName){
//        return treatmentRecordRepository.searchRecordsByAnimalName(animalName);
//    }



}
