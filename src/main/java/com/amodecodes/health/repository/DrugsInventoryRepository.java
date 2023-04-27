package com.amodecodes.health.repository;

import com.amodecodes.health.entity.DrugsInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugsInventoryRepository extends JpaRepository<DrugsInventory, Long> {

    Object findAll();

    Object findById(Long drugId);

    Object delete(DrugsInventory drug);

    Object save(DrugsInventory drug);
}
