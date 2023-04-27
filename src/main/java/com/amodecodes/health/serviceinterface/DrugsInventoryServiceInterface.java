package com.amodecodes.health.serviceinterface;

import com.amodecodes.health.entity.DrugsInventory;

import java.util.List;

public interface DrugsInventoryServiceInterface {

    List<DrugsInventory> getAllDrugsInventories();
    DrugsInventory getDrugsInventoryById(Long drugId);
    DrugsInventory addNewDrugsInventory(DrugsInventory drug);
    DrugsInventory updateDrugsInventory(Long drugId, DrugsInventory drugUpdatedDetails);
    void deleteDrugsInventory(Long drugId);
}
