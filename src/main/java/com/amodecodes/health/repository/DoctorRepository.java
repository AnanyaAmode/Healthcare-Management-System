package com.amodecodes.health.repository;

import com.amodecodes.health.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Object findAll();

    Object findById(Long doctorId);

    Object save(Doctor any);

    Object delete(Doctor doctor);
}
