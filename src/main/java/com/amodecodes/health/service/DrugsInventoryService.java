package com.amodecodes.health.service;

import com.amodecodes.health.entity.DrugsInventory;
import com.amodecodes.health.exception.ResourceNotFoundException;
import com.amodecodes.health.repository.DrugsInventoryRepository;
import com.amodecodes.health.serviceinterface.DrugsInventoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugsInventoryService implements DrugsInventoryServiceInterface {

    private final DrugsInventoryRepository drugsInventoryRepository;

    @Autowired
    public DrugsInventoryService(DrugsInventoryRepository drugsInventoryRepository) {
        this.drugsInventoryRepository = drugsInventoryRepository;
    }

    @Override
    public List<DrugsInventory> getAllDrugsInventories() {
        return drugsInventoryRepository.findAll();
    }

    @Override
    public DrugsInventory getDrugsInventoryById(Long drugId) {
        return drugsInventoryRepository.findById(drugId)
                .orElseThrow(()-> new ResourceNotFoundException("Drug with id " + drugId + " doesn't exist."));
    }

    @Override
    public DrugsInventory addNewDrugsInventory(DrugsInventory drug) {
        return drugsInventoryRepository.save(drug);
    }

    @Override
    public DrugsInventory updateDrugsInventory(Long drugId, DrugsInventory drugUpdatedDetails) {
        DrugsInventory updatedDrug = drugsInventoryRepository.findById(drugId)
                .orElseThrow(()-> new ResourceNotFoundException("Drug with id " + drugId + " doesn't exist."));
        updatedDrug.setName(drugUpdatedDetails.getName());
        updatedDrug.setUnitOfMeasurement(drugUpdatedDetails.getUnitOfMeasurement());
        updatedDrug.setQuantityInStock(drugUpdatedDetails.getQuantityInStock());
        return drugsInventoryRepository.save(updatedDrug);
    }

    @Override
    public void deleteDrugsInventory(Long drugId) {
        DrugsInventory drug = drugsInventoryRepository.findById(drugId)
                .orElseThrow(()-> new ResourceNotFoundException("Drug with id " + drugId + " doesn't exist."));
        drugsInventoryRepository.delete(drug);
    }
}
