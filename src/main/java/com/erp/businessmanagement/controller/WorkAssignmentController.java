package com.erp.businessmanagement.controller;

import com.erp.businessmanagement.dto.WorkAssignmentDTO;
import com.erp.businessmanagement.entity.WorkAssignment;
import com.erp.businessmanagement.entity.AssignmentWorker;
import com.erp.businessmanagement.entity.Worker;
import com.erp.businessmanagement.entity.order;
import com.erp.businessmanagement.entity.fabrics;
import com.erp.businessmanagement.entity.SofaModel;
import com.erp.businessmanagement.entity.sofa_designs;
import com.erp.businessmanagement.repository.WorkAssignmentRepository;
import com.erp.businessmanagement.repository.WorkerRepository;
import com.erp.businessmanagement.repository.AssignmentWorkerRepository;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
@RequestMapping("/api/assignments")
@CrossOrigin(origins = "http://localhost:3000")
public class WorkAssignmentController {

    @Autowired
    private WorkAssignmentRepository workAssignmentRepository;

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private AssignmentWorkerRepository assignmentWorkerRepository;

    @PostMapping
    public String assignWork(@RequestBody WorkAssignmentDTO dto) {
        // 1. Save WorkAssignment
        WorkAssignment assignment = new WorkAssignment();

        assignment.setOrder(new order(dto.getOrderId()));
        assignment.setAssignDate(dto.getAssignDate());
        assignment.setFabric(new fabrics(dto.getFabricId()));
        assignment.setModel(new SofaModel(dto.getModelId()));
        assignment.setDesign(new sofa_designs(dto.getDesignId()));  // ✅ corrected
        assignment.setExpCompDate(dto.getExpectedCompletionDate());
        assignment.setInstruction(dto.getInstruction());

        WorkAssignment savedAssignment = workAssignmentRepository.save(assignment);

        // 2. Save assignment_worker entries
        for (Integer workerId : dto.getWorkerIds()) {
            Worker workerObj = workerRepository.findById(workerId).orElse(null);
            if (workerObj != null) {
                AssignmentWorker link = new AssignmentWorker();
                link.setWorkAssignment(savedAssignment);
                link.setWorker(workerObj);
                assignmentWorkerRepository.save(link);
            }
        }

        return "✅ Work assigned successfully";
    }
}
