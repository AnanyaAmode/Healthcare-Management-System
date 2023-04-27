package com.amodecodes.health.serviceinterface;

import com.amodecodes.health.entity.Doctor;

import java.util.List;

public interface DoctorServiceInterface {

    List<Doctor> getAllDoctors();
    Doctor getDoctorById(Long doctorId);
    Doctor registerNewDoctor(Doctor doctor);
    Doctor updateDoctor(Long doctorId, Doctor doctorUpdatedDetails);
    void deleteDoctor(Long doctorId);
}
