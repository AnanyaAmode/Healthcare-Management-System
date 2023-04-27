package com.amodecodes.health.serviceinterface;

import com.amodecodes.health.entity.PatientMedicalHistory;

import java.util.List;

public interface PatientMedicalHistoryServiceInterface {

    List<PatientMedicalHistory> getAllPatientMedicalHistories();
    PatientMedicalHistory getPatientMedicalHistoryById(Long patientMedicalHistoryId);
    PatientMedicalHistory addNewPatientMedicalHistory(PatientMedicalHistory patientMedicalHistory);
    PatientMedicalHistory updatePatientMedicalHistory(Long patientMedicalHistoryId, PatientMedicalHistory patientMedicalHistoryUpdatedDetails);
    void deletePatientMedicalHistory(Long patientMedicalHistoryId);
    PatientMedicalHistory connectPatientMedicalHistoryToPatient(Long patientMedicalHistoryId, Long patientId);
    PatientMedicalHistory connectPatientMedicalHistoryToDoctor(Long patientMedicalHistoryId, Long doctorId);
    PatientMedicalHistory addPatientMedicalHistoryToBill(Long patientMedicalHistoryId, Long billId);
}

