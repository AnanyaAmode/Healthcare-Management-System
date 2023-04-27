package com.amodecodes.health.repository;

import com.amodecodes.health.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Object findAll();

    Object findById(Long patientId);

    Object save(Patient any);

    Object delete(Patient patient);
}
