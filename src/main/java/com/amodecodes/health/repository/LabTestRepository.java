package com.amodecodes.health.repository;

import com.amodecodes.health.entity.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabTestRepository extends JpaRepository<LabTest, Long> {

    Object findById(Long labTestId);

    Object findAll();

    Object save(LabTest any);

    Object delete(LabTest labTest);
}
