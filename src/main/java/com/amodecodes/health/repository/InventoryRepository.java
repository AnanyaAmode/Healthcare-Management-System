package com.amodecodes.health.repository;

import com.amodecodes.health.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Object findAll();

    Object findById(Long inventoryId);

    Object save(Inventory inventory);

    Object delete(Inventory inventory);
}