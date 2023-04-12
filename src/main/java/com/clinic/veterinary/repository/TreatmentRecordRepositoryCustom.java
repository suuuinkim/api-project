package com.clinic.veterinary.repository;

import com.clinic.veterinary.repository.domain.RecordSearchCondition;
import com.clinic.veterinary.repository.domain.TreatmentRecord;
import com.clinic.veterinary.repository.domain.dto.TreatmentRecordDto;

import java.util.List;

public interface TreatmentRecordRepositoryCustom {

    List<TreatmentRecord> search(RecordSearchCondition condition);
}
