package com.amodecodes.health.repository;

import com.amodecodes.health.entity.DoctorsInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorsInformationRepository extends JpaRepository<DoctorsInformation, Long> {

    Object findAll();

    Object findById(Long doctorsInformationId);

    Object save(DoctorsInformation any);

    Object delete(DoctorsInformation doctorsInformation);
}
