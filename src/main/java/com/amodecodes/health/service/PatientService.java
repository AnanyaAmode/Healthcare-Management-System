package com.amodecodes.health.service;

import com.amodecodes.health.entity.Patient;
import com.amodecodes.health.exception.ResourceNotFoundException;
import com.amodecodes.health.repository.PatientRepository;
import com.amodecodes.health.serviceinterface.PatientServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements PatientServiceInterface {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long patientId) {
        return patientRepository.findById(patientId)
                .orElseThrow(()-> new ResourceNotFoundException("Patient with id " + patientId + " doesn't exist."));
    }

    @Override
    public Patient registerNewPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Long patientId, Patient patientUpdatedDetails) {
        Patient updatedPatient = patientRepository.findById(patientId)
                .orElseThrow(()-> new ResourceNotFoundException("Patient with id " + patientId + " doesn't exist." ));
        updatedPatient.setFullName(patientUpdatedDetails.getFullName());
        updatedPatient.setDateOfBirth(patientUpdatedDetails.getDateOfBirth());
        updatedPatient.setAddress(patientUpdatedDetails.getAddress());
        updatedPatient.setIdNumber(patientUpdatedDetails.getIdNumber());
        updatedPatient.setPersonalIdentificationNumber(patientUpdatedDetails.getPersonalIdentificationNumber());
        updatedPatient.setEmailAddress(patientUpdatedDetails.getEmailAddress());
        return patientRepository.save(updatedPatient);
    }

    @Override
    public void deletePatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new ResourceNotFoundException("Patient with id " + patientId + " doesn't exist."));
        patientRepository.delete(patient);
    }
}

