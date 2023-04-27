package com.amodecodes.health.serviceinterface;

import com.amodecodes.health.entity.MedicalServiceSystem;

import java.util.List;

public interface MedicalServiceSystemServiceInterface {

    List<MedicalServiceSystem> getAllMedicalServices();
    MedicalServiceSystem getMedicalServiceById(Long medicalServiceId);
    MedicalServiceSystem addNewMedicalService(MedicalServiceSystem medicalService);
    MedicalServiceSystem updateMedicalService(Long medicalServiceId, MedicalServiceSystem medicalServiceUpdatedDetails);
    void deleteMedicalService(Long medicalServiceId);
}

