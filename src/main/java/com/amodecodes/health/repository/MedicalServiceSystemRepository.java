package com.amodecodes.health.repository;

import com.amodecodes.health.entity.MedicalServiceSystem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalServiceSystemRepository extends JpaRepository<MedicalServiceSystem, Long> {

    Object findAll();

    Object findById(Long medicalServiceId);

    Object save(MedicalServiceSystem any);

    Object delete(MedicalServiceSystem medicalService);
}
