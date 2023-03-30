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

        Long id = treatmentRecordService.treatmentRecord(request.getDoctorId(), request.getAnimalId(),
                request.getAnimalTypeId(), request.getRecordContent());

        treatmentRecordService.createRecordTreatmentArea(id, request.getTreatmentAreaId());
        return new CreateRecordResponse(id);
    }


    /**
     * 진료기록 수정
     */
    @PutMapping("/api/v1/record/{id}")
    public UpdateRecordResponse updateRecordV1(@PathVariable("id") Long id, @RequestBody @Valid UpdateRecordRequest request){

        treatmentRecordService.update(id, request.getRecordContent());
        TreatmentRecord findRecord = treatmentRecordService.findOne(id);
        return new UpdateRecordResponse(findRecord.getId(), findRecord.getRecordContent());
    }

    /**
     * 진료기록 삭제
     */
    @DeleteMapping("/api/v1/record/{id}")
    public DeleteRecordResponse deleteRecordV1(@PathVariable("id") Long id){
        return treatmentRecordService.delete(id);
    }

    /**
     * 진료기록 검색
     */
    @GetMapping("/api/v1/record/search")
    public List<TreatmentRecordDto> searchRecordV1(@RequestParam String doctorName) {
        List<TreatmentRecord> records = treatmentRecordRepository.searchRecordsByDoctorName(doctorName);

        List<TreatmentRecordDto> collect = records.stream()
                .map(r -> new TreatmentRecordDto(r))
                .collect(Collectors.toList());

        return collect;
    }


}
