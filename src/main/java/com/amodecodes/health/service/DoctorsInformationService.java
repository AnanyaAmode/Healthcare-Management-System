package com.amodecodes.health.service;

import com.amodecodes.health.entity.DoctorsInformation;
import com.amodecodes.health.exception.ResourceNotFoundException;
import com.amodecodes.health.repository.DoctorsInformationRepository;
import com.amodecodes.health.serviceinterface.DoctorsInformationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorsInformationService implements DoctorsInformationServiceInterface {

    private final DoctorsInformationRepository doctorsInformationRepository;

    @Autowired
    public DoctorsInformationService(DoctorsInformationRepository doctorsInformationRepository) {
        this.doctorsInformationRepository = doctorsInformationRepository;
    }

    @Override
    public List<DoctorsInformation> getAllDoctorsInformation() {
        return doctorsInformationRepository.findAll();
    }

    @Override
    public DoctorsInformation getDoctorsInformationById(Long doctorsInformationId) {
        return doctorsInformationRepository.findById(doctorsInformationId)
                .orElseThrow(()-> new ResourceNotFoundException("Doctor's information with id " + doctorsInformationId + " doesn't exist."));
    }

    @Override
    public DoctorsInformation addNewDoctorsInformation(DoctorsInformation doctorsInformation) {
        return doctorsInformationRepository.save(doctorsInformation);
    }

    @Override
    public DoctorsInformation updateDoctorsInformation(Long doctorInformationId, DoctorsInformation doctorInformationUpdatedDetails) {
        DoctorsInformation updatedDoctorsInformation = doctorsInformationRepository.findById(doctorInformationId)
                .orElseThrow(()-> new ResourceNotFoundException("Doctor's infromation with id " + doctorInformationId + " doesn't exist."));
        updatedDoctorsInformation.setFullName(doctorInformationUpdatedDetails.getFullName());
        updatedDoctorsInformation.setDateOfBirth(doctorInformationUpdatedDetails.getDateOfBirth());
        updatedDoctorsInformation.setEmailAddress(doctorInformationUpdatedDetails.getEmailAddress());
        return doctorsInformationRepository.save(updatedDoctorsInformation);
    }

    @Override
    public void deleteDoctorsInformation(Long doctorsInformationId) {
        DoctorsInformation doctorsInformation = doctorsInformationRepository.findById(doctorsInformationId)
                .orElseThrow(()-> new ResourceNotFoundException("Doctor's information with id " + doctorsInformationId + " doesn't exist."));
        doctorsInformationRepository.delete(doctorsInformation);
    }
}
