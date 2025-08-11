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
import com.erp.businessmanagement.repository.OrderRepository;
import com.erp.businessmanagement.repository.fabricsRepository;
import com.erp.businessmanagement.repository.SofaModelRepository;
import com.erp.businessmanagement.repository.sofa_designsRepository;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private fabricsRepository fabricRepository;

    @Autowired
    private SofaModelRepository sofaModelRepository;

    @Autowired
    private sofa_designsRepository sofaDesignRepository;

    @PostMapping
    public String assignWork(@RequestBody WorkAssignmentDTO dto) {
        try {
            System.out.println("📥 Incoming DTO: " + dto);

            // ✅ Fetch existing entities from DB
            order existingOrder = orderRepository.findById(dto.getOrderId())
                    .orElseThrow(() -> new RuntimeException("Order not found with ID: " + dto.getOrderId()));

            fabrics existingFabric = fabricRepository.findById(dto.getFabricId())
                    .orElseThrow(() -> new RuntimeException("Fabric not found with ID: " + dto.getFabricId()));

            SofaModel existingModel = sofaModelRepository.findById(dto.getModelId())
                    .orElseThrow(() -> new RuntimeException("Sofa Model not found with ID: " + dto.getModelId()));

            sofa_designs existingDesign = sofaDesignRepository.findById(dto.getDesignId())
                    .orElseThrow(() -> new RuntimeException("Sofa Design not found with ID: " + dto.getDesignId()));

            // ✅ Create and set WorkAssignment
            WorkAssignment assignment = new WorkAssignment();
            assignment.setOrder(existingOrder);
            assignment.setAssignDate(dto.getAssignDate());
            assignment.setFabric(existingFabric);
            assignment.setModel(existingModel);
            assignment.setDesign(existingDesign);
            assignment.setExpCompDate(dto.getExpectedCompletionDate());
            assignment.setInstruction(dto.getInstruction());

            WorkAssignment savedAssignment = workAssignmentRepository.save(assignment);

            // ✅ Save worker links
            for (Integer workerId : dto.getWorkerIds()) {
                Worker workerObj = workerRepository.findById(workerId).orElse(null);
                if (workerObj != null) {
                    AssignmentWorker link = new AssignmentWorker();
                    link.setAssignment(savedAssignment);
                    link.setWorker(workerObj);
                    assignmentWorkerRepository.save(link);
                } else {
                    System.err.println("❌ Worker not found with ID: " + workerId);
                }
            }

            return "✅ Work assigned successfully";
        } catch (Exception e) {
            e.printStackTrace(); // Full error in console
            return "❌ Error: " + e.getMessage();
        }
    }
}
