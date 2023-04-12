package com.clinic.veterinary.repository;

import com.clinic.veterinary.domain.TreatmentRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRecordRepository extends JpaRepository<TreatmentRecord, Long>, TreatmentRecordRepositoryCustom {

}
