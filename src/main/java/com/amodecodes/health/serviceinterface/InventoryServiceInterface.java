package com.amodecodes.health.serviceinterface;

import com.amodecodes.health.entity.Inventory;

import java.util.List;

public interface InventoryServiceInterface {

    List<Inventory> getAllInventories();
    Inventory getInventoryById(Long inventoryId);
    Inventory addNewInventory(Inventory inventory);
    Inventory updateInventory(Long inventoryId, Inventory inventoryUpdatedDetails);
    void deleteInventory(Long inventoryId);
}
