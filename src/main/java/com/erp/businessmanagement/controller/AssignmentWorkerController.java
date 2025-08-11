package com.erp.businessmanagement.controller;

import com.erp.businessmanagement.entity.AssignmentWorker;
import com.erp.businessmanagement.entity.WorkAssignment;
import com.erp.businessmanagement.entity.Worker;
import com.erp.businessmanagement.repository.AssignmentWorkerRepository;
import com.erp.businessmanagement.repository.WorkAssignmentRepository;
import com.erp.businessmanagement.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignment-workers")
@CrossOrigin(origins = "http://localhost:3000")
public class AssignmentWorkerController {

    @Autowired
    private AssignmentWorkerRepository assignmentWorkerRepository;

    @Autowired
    private WorkAssignmentRepository workAssignmentRepository;

    @Autowired
    private WorkerRepository workerRepository;

    // ✅ 1. Get all worker-assignments
    @GetMapping
    public List<AssignmentWorker> getAllAssignments() {
        return assignmentWorkerRepository.findAll();
    }

    // ✅ 2. Assign multiple workers to an assignment
    @PostMapping
    public String assignWorkersToAssignment(@RequestParam Integer assignmentId, @RequestBody List<Integer> workerIds) {
        WorkAssignment assignment = workAssignmentRepository.findById(assignmentId).orElse(null);
        if (assignment == null) {
            return "❌ Assignment not found";
        }

        for (Integer workerId : workerIds) {
            Worker worker = workerRepository.findById(workerId).orElse(null);
            if (worker != null) {
                AssignmentWorker aw = new AssignmentWorker(assignment, worker);
                assignmentWorkerRepository.save(aw);
            }
        }

        return "✅ Workers assigned to assignment ID: " + assignmentId;
    }
}