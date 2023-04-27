package com.amodecodes.health.repository;

import com.amodecodes.health.entity.PrescribedMedication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescribedMedicationRepository extends JpaRepository<PrescribedMedication, Long> {

    Object findAll();

    Object findById(Long prescribedMedicationId);

    Object save(PrescribedMedication any);

    void delete(PrescribedMedication prescribedMedication);
}