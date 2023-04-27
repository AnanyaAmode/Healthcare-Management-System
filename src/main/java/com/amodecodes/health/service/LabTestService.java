package com.amodecodes.health.service;

import com.amodecodes.health.entity.LabTest;
import com.amodecodes.health.entity.Patient;
import com.amodecodes.health.exception.ResourceNotFoundException;
import com.amodecodes.health.repository.LabTestRepository;
import com.amodecodes.health.repository.PatientRepository;
import com.amodecodes.health.serviceinterface.LabTestServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabTestService implements LabTestServiceInterface {

    private final LabTestRepository labTestRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public LabTestService(LabTestRepository labTestRepository, PatientRepository patientRepository) {
        this.labTestRepository = labTestRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<LabTest> getAllLabTests() {
        return labTestRepository.findAll();
    }

    @Override
    public LabTest getLabTestById(Long labTestId) {
        return labTestRepository.findById(labTestId)
                .orElseThrow(()-> new ResourceNotFoundException("Lab test with id " + labTestId + " doesn't exist."));
    }

    @Override
    public LabTest addNewLabTest(LabTest labTest) {
        return labTestRepository.save(labTest);
    }

    @Override
    public LabTest updateLabTest(Long labTestId, LabTest labTestUpdatedDetails) {
        LabTest updatedLabTest = labTestRepository.findById(labTestId)
                .orElseThrow(()-> new ResourceNotFoundException("Lab test with id " + labTestId + " doesn't exist."));
        updatedLabTest.setName(labTestUpdatedDetails.getName());
        updatedLabTest.setTestDetailsDescription(labTestUpdatedDetails.getTestDetailsDescription());
        updatedLabTest.setDateWhenLabTestDone(labTestUpdatedDetails.getDateWhenLabTestDone());
        return labTestRepository.save(updatedLabTest);
    }

    @Override
    public void deleteLabTest(Long labTestId) {
        LabTest labTest = labTestRepository.findById(labTestId)
                .orElseThrow(()-> new ResourceNotFoundException("Lab test with id " + labTestId + " doesn't exist."));
        labTestRepository.delete(labTest);
    }

    @Override
    public LabTest connectLabTestToPatient(Long labTestId, Long patientId) {
        LabTest labTest = labTestRepository.findById(labTestId)
                .orElseThrow(()-> new ResourceNotFoundException("Lab test with id " + labTestId + " doesn't exist."));
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new ResourceNotFoundException("Patient with id " + patientId + " doesn't exist."));
        labTest.connectToPatient(patient);
        return labTestRepository.save(labTest);
    }
}

