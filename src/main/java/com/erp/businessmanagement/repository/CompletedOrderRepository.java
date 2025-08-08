package com.erp.businessmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.erp.businessmanagement.entity.CompletedOrder;

public interface CompletedOrderRepository extends JpaRepository<CompletedOrder, Integer> {
}
