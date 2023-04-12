package com.clinic.veterinary.api.controller;

import com.clinic.veterinary.api.*;
import com.clinic.veterinary.repository.domain.RecordSearchCondition;
import com.clinic.veterinary.repository.domain.TreatmentRecord;
import com.clinic.veterinary.repository.domain.dto.TreatmentRecordDto;
import com.clinic.veterinary.repository.TreatmentRecordRepository;
import com.clinic.veterinary.service.TreatmentRecordService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
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
    @ApiOperation(value = "진료기록 조회 API")
    public List<TreatmentRecordDto> recordsV1(){
        List<TreatmentRecord> records = treatmentRecordRepository.findAll();

        List<TreatmentRecordDto> collect = records.stream()
                .map(r -> new TreatmentRecordDto(r))
                .collect(Collectors.toList());

        return collect;
    }


    /**
     * 진료기록 저장
     */
    @PostMapping("/api/v1/record")
    @ApiOperation(value = "진료기록 저장 API")
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
    @ApiOperation(value = "진료기록 수정 API")
    public UpdateRecordResponse updateRecordV1(@PathVariable("id") Long id, @RequestBody @Valid UpdateRecordRequest request){

        try{
            treatmentRecordService.update(id, request.getRecordContent());
            Optional<TreatmentRecord> findRecord = treatmentRecordService.findOne(id);

            return new UpdateRecordResponse(true, findRecord.get().getId(), "진료기록을 수정하였습니다.");
        }catch (Exception ex){
            return new UpdateRecordResponse(false, null, "진료기록을 수정하는데 실패했습니다. 확인해주세요.");
        }
    }

    /**
     * 진료기록 삭제
     */
    @DeleteMapping("/api/v1/record/{id}")
    @ApiOperation(value = "진료기록 삭제 API")
    public DeleteRecordResponse deleteRecordV1(@PathVariable("id") Long id){
        return treatmentRecordService.delete(id);
    }

//    /**
//     * 진료기록 삭제 by 동물이름
//     */
//    @DeleteMapping("/api/v1/records/{animalName}")
//    @ApiOperation(value = "진료기록 동물이름으로 삭제 API")
//    @Transactional
//    public DeleteRecordResponse deleteRecordsByAnimalNameV1(@PathVariable("animalName") String animalName) {
//        List<TreatmentRecord> searchRecordsByAnimalName = treatmentRecordRepository.searchRecords(null, animalName);
//
//        for (TreatmentRecord record : searchRecordsByAnimalName) {
//            treatmentRecordRepository.delete(record);
//        }
//
//        return new DeleteRecordResponse(true,  "진료기록을 삭제했습니다.");
//    }
//
//
    /**
     * 진료기록 검색
     */
    @GetMapping("/api/v1/record/searchRecord")
    @ApiOperation(value = "진료기록 검색 API")
    public List<TreatmentRecordDto> searchRecords(RecordSearchCondition condition){
        List<TreatmentRecord> records = treatmentRecordRepository.search(condition);


        List<TreatmentRecordDto> collect = records.stream()
                .map(r -> new TreatmentRecordDto(r))
                .collect(Collectors.toList());

        return collect;
    }

}
