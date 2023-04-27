package com.amodecodes.health.service;

import com.amodecodes.health.entity.Inventory;
import com.amodecodes.health.exception.ResourceNotFoundException;
import com.amodecodes.health.repository.InventoryRepository;
import com.amodecodes.health.serviceinterface.InventoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService implements InventoryServiceInterface {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory getInventoryById(Long inventoryId) {
        return inventoryRepository.findById(inventoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Inventory with id " + inventoryId + " doesn't exist."));
    }

    @Override
    public Inventory addNewInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory updateInventory(Long inventoryId, Inventory inventoryUpdatedDetails) {
        Inventory updatedInventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Inventory with id " + inventoryId + " doesn't exist."));
        updatedInventory.setName(inventoryUpdatedDetails.getName());
        updatedInventory.setUnitOfMeasurement(inventoryUpdatedDetails.getUnitOfMeasurement());
        updatedInventory.setQuantityInStock(inventoryUpdatedDetails.getQuantityInStock());
        return inventoryRepository.save(updatedInventory);
    }

    @Override
    public void deleteInventory(Long inventoryId) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Inventory with id " + inventoryId + " doesn't exist."));
        inventoryRepository.delete(inventory);
    }
}
