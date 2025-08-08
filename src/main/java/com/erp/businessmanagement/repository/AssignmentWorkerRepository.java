package com.erp.businessmanagement.repository;

import com.erp.businessmanagement.entity.AssignmentWorker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentWorkerRepository extends JpaRepository<AssignmentWorker, Integer> {
    // You can add custom queries here if needed later
}
