package com.amodecodes.health.repository;

import com.amodecodes.health.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    Object findById(Long appointmentId);

    void findAll();

    void save(Appointment appointment);

    void delete(Appointment appointment);
}
