package com.erp.businessmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.erp.businessmanagement.entity.CompletedOrder;
import com.erp.businessmanagement.repository.CompletedOrderRepository;

@RestController
@RequestMapping("/api/completed-orders")
@CrossOrigin(origins = "http://localhost:3000")
public class CompletedOrderController {

    @Autowired
    private CompletedOrderRepository completedOrderRepository;

    // ✅ Get all completed orders
    @GetMapping
    public List<CompletedOrder> getAllCompletedOrders() {
        return completedOrderRepository.findAll();
    }

    // ✅ Get by ID
    @GetMapping("/{id}")
    public CompletedOrder getCompletedOrderById(@PathVariable Integer id) {
        return completedOrderRepository.findById(id).orElse(null);
    }

    // ❌ Normally, we don’t need create manually – handled via OrderController
    // But for testing, we can allow POST too:
    @PostMapping
    public CompletedOrder createCompletedOrder(@RequestBody CompletedOrder completedOrder) {
        return completedOrderRepository.save(completedOrder);
    }

    // ✅ Delete completed order (optional)
    @DeleteMapping("/{id}")
    public void deleteCompletedOrder(@PathVariable Integer id) {
        completedOrderRepository.deleteById(id);
    }
}
