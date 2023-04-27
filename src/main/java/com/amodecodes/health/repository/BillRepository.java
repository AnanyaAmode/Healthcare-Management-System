package com.amodecodes.health.repository;

import com.amodecodes.health.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {

    Object findAll();

    Object findById(Long billId);

    void save(Bill bill);

    void delete(Bill bill);
}
