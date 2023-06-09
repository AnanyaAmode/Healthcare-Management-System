package com.amodecodes.health.service;

import com.amodecodes.health.entity.Appointment;
import com.amodecodes.health.entity.Patient;
import com.amodecodes.health.exception.ResourceNotFoundException;
import com.amodecodes.health.repository.AppointmentRepository;
import com.amodecodes.health.repository.PatientRepository;
import com.amodecodes.health.serviceinterface.AppointmentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService implements AppointmentServiceInterface {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(()-> new ResourceNotFoundException("Appointment with id " + appointmentId + " doesn't exist."));
    }

    @Override
    public Appointment createNewAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Long appointmentId, Appointment appointmentUpdatedDetails) {
        Appointment updatedAppointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(()-> new ResourceNotFoundException("Appointment with id " + appointmentId + " doesn't exist."));
        updatedAppointment.setDateOfAppointment(appointmentUpdatedDetails.getDateOfAppointment());
        return appointmentRepository.save(updatedAppointment);
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(()-> new ResourceNotFoundException("Appointment with id " + appointmentId + " doesn't exist."));
        appointmentRepository.delete(appointment);
    }

    @Override
    public Appointment makeAppointmentWithPatient(Long appointmentId, Long patientId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(()-> new ResourceNotFoundException("Appointment with id " + appointmentId + " doesn't exist."));
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new ResourceNotFoundException("Patient with id " + patientId + " doesn't exist."));
        appointment.connectWithPatient(patient);
        return appointmentRepository.save(appointment);
    }
}

