package com.amodecodes.health.repository;

import com.amodecodes.health.entity.DoctorServiceReportSystem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorServiceReportSystemRepository extends JpaRepository<DoctorServiceReportSystem, Long> {

    Object findAll();

    Object findById(Long doctorServiceReportId);

    Object save(DoctorServiceReportSystem doctorServiceReport);

    Object delete(DoctorServiceReportSystem doctorServiceReport);
}
