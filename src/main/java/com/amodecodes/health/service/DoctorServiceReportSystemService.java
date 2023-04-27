package com.amodecodes.health.service;

import com.amodecodes.health.entity.Doctor;
import com.amodecodes.health.entity.DoctorServiceReportSystem;
import com.amodecodes.health.exception.ResourceNotFoundException;
import com.amodecodes.health.repository.DoctorRepository;
import com.amodecodes.health.repository.DoctorServiceReportSystemRepository;
import com.amodecodes.health.serviceinterface.DoctorServiceReportSystemServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceReportSystemService implements DoctorServiceReportSystemServiceInterface {

    private final DoctorServiceReportSystemRepository doctorServiceReportSystemRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceReportSystemService(DoctorServiceReportSystemRepository doctorServiceReportSystemRepository, DoctorRepository doctorRepository) {
        this.doctorServiceReportSystemRepository = doctorServiceReportSystemRepository;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<DoctorServiceReportSystem> getAllDoctorServiceReports() {
        return doctorServiceReportSystemRepository.findAll();
    }

    @Override
    public DoctorServiceReportSystem getDoctorServiceReportById(Long doctorServiceReportId) {
        return doctorServiceReportSystemRepository.findById(doctorServiceReportId)
                .orElseThrow(()-> new ResourceNotFoundException("Doctor service report with id " + doctorServiceReportId + " doesn't exist."));
    }

    @Override
    public DoctorServiceReportSystem addNewDoctorServiceReport(DoctorServiceReportSystem doctorServiceReport) {
        return doctorServiceReportSystemRepository.save(doctorServiceReport);
    }

    @Override
    public DoctorServiceReportSystem updateDoctorServiceReport(Long doctorServiceReportId, DoctorServiceReportSystem doctorServiceReportUpdatedDetails) {
        DoctorServiceReportSystem updatedDoctorServiceReport = doctorServiceReportSystemRepository.findById(doctorServiceReportId)
                .orElseThrow(()-> new ResourceNotFoundException("Doctor service report with id " + doctorServiceReportId + " doesn't exist."));
        updatedDoctorServiceReport.setSpecializationField(doctorServiceReportUpdatedDetails.getSpecializationField());
        updatedDoctorServiceReport.setWorkEfficiency(doctorServiceReportUpdatedDetails.getWorkEfficiency());
        updatedDoctorServiceReport.setDutyHours(doctorServiceReportUpdatedDetails.getDutyHours());
        return doctorServiceReportSystemRepository.save(updatedDoctorServiceReport);
    }

    @Override
    public void deleteDoctorServiceReport(Long doctorServiceReportId) {
        DoctorServiceReportSystem doctorServiceReport = doctorServiceReportSystemRepository.findById(doctorServiceReportId)
                .orElseThrow(()-> new ResourceNotFoundException("Doctor service report with id " + doctorServiceReportId + " doesn't exist."));
        doctorServiceReportSystemRepository.delete(doctorServiceReport);
    }

    @Override
    public DoctorServiceReportSystem addDoctorServiceReportToDoctor(Long doctorServiceReportId, Long doctorId) {
        DoctorServiceReportSystem doctorServiceReport = doctorServiceReportSystemRepository.findById(doctorServiceReportId)
                .orElseThrow(()-> new ResourceNotFoundException("Doctor service report with id " + doctorServiceReportId + " doesn't exist."));
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(()-> new ResourceNotFoundException("Doctor with id " + doctorId + " doesn't exist."));
        doctorServiceReport.addToDoctor(doctor);
        return doctorServiceReportSystemRepository.save(doctorServiceReport);
    }
