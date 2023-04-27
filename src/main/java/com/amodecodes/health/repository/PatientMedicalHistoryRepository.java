package com.amodecodes.health.repository;

import com.amodecodes.health.entity.PatientMedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientMedicalHistoryRepository extends JpaRepository<PatientMedicalHistory, Long> {

    Object findAll();

    Object findById(Long patientMedicalHistoryId);

    Object save(PatientMedicalHistory any);

    Object delete(PatientMedicalHistory patientMedicalHistory);
}
