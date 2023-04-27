package com.amodecodes.health.service;

import com.amodecodes.health.entity.Doctor;
import com.amodecodes.health.exception.ResourceNotFoundException;
import com.amodecodes.health.repository.DoctorRepository;
import com.amodecodes.health.serviceinterface.DoctorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements DoctorServiceInterface {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId)
                .orElseThrow(()-> new ResourceNotFoundException("Doctor with id " + doctorId + " doesn't exist."));
    }

    @Override
    public Doctor registerNewDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Long doctorId, Doctor doctorUpdatedDetails) {
        Doctor updatedDoctor = doctorRepository.findById(doctorId)
                .orElseThrow(()-> new ResourceNotFoundException("Doctor with id " + doctorId + " doesn't exist."));
        updatedDoctor.setFullName(doctorUpdatedDetails.getFullName());
        updatedDoctor.setDateOfBirth(doctorUpdatedDetails.getDateOfBirth());
        updatedDoctor.setAddress(doctorUpdatedDetails.getAddress());
        updatedDoctor.setIdNumber(doctorUpdatedDetails.getIdNumber());
        updatedDoctor.setPersonalIdentificationNumber(doctorUpdatedDetails.getPersonalIdentificationNumber());
        updatedDoctor.setEmailAddress(doctorUpdatedDetails.getEmailAddress());
        return doctorRepository.save(updatedDoctor);

    }

    @Override
    public void deleteDoctor(Long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(()-> new ResourceNotFoundException("Doctor with id " + doctorId + " doesn't exist."));
        doctorRepository.delete(doctor);
    }
}

