package com.erp.businessmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.erp.businessmanagement.entity.WorkAssignment;

public interface WorkAssignmentRepository extends JpaRepository<WorkAssignment, Integer> {
    // You can add custom queries here if needed later
}
