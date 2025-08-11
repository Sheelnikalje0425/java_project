package com.erp.businessmanagement.repository;

import com.erp.businessmanagement.entity.AssignmentWorker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentWorkerRepository extends JpaRepository<AssignmentWorker, Integer> {

    // Custom finder method
    List<AssignmentWorker> findByAssignmentId(Integer assignmentId);
}
