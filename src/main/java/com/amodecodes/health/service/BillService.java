package com.amodecodes.health.service;

import com.amodecodes.health.entity.Bill;
import com.amodecodes.health.entity.Patient;
import com.amodecodes.health.ResourceNotFoundException;
import com.amodecodes.health.repository.BillRepository;
import com.amodecodes.health.repository.PatientRepository;
import com.amodecodes.health.serviceinterface.BillServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService implements BillServiceInterface {

    private final BillRepository billRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public BillService(BillRepository billRepository, PatientRepository patientRepository) {
        this.billRepository = billRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    @Override
    public Bill getBillById(Long billId) {
        return billRepository.findById(billId)
                .orElseThrow(()-> new ResourceNotFoundException("Bill with id " + billId + " doesn't exist."));
    }

    @Override
    public Bill generateNewBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Bill updateBill(Long billId, Bill billUpdatedDetails) {
        Bill updatedBill = billRepository.findById(billId)
                .orElseThrow(()-> new ResourceNotFoundException("Bill with id " + billId + " doesn't exist."));
        updatedBill.setDateOfBill(billUpdatedDetails.getDateOfBill());
        updatedBill.setHospitalServicesDescription(billUpdatedDetails.getHospitalServicesDescription());
        updatedBill.setPrice(billUpdatedDetails.getPrice());
        return billRepository.save(updatedBill);
    }

    @Override
    public void deleteBill(Long billId) {
        Bill bill = billRepository.findById(billId)
                .orElseThrow(()-> new ResourceNotFoundException("Bill with id " + billId + " doesn't exist."));
        billRepository.delete(bill);
    }

    @Override
    public Bill generateBillToPatient(Long billId, Long patientId) {
        Bill bill = billRepository.findById(billId)
                .orElseThrow(()-> new ResourceNotFoundException("Bill with id " + billId + " doesn't exist."));
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new ResourceNotFoundException("Patient with id " + patientId + " doesn't exist."));
        bill.connectPatient(patient);
        return billRepository.save(bill);
    }
}
