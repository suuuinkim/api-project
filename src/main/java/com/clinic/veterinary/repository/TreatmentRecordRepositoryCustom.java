package com.clinic.veterinary.repository;

import com.clinic.veterinary.domain.RecordSearchCondition;
import com.clinic.veterinary.domain.TreatmentRecord;

import java.util.List;

public interface TreatmentRecordRepositoryCustom {
    List<TreatmentRecord> search(RecordSearchCondition condition);
}
