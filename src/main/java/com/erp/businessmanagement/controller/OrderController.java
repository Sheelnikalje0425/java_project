package com.erp.businessmanagement.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.erp.businessmanagement.entity.order;
import com.erp.businessmanagement.entity.order.Status;
import com.erp.businessmanagement.entity.CompletedOrder;
import com.erp.businessmanagement.repository.OrderRepository;
import com.erp.businessmanagement.repository.CompletedOrderRepository;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CompletedOrderRepository completedOrderRepository;

    // ✅ Get all orders
    @GetMapping
    public List<order> getAllOrders() {
        return orderRepository.findAll();
    }

    // ✅ Get order by ID
    @GetMapping("/{id}")
    public order getOrderById(@PathVariable Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    // ✅ Create new order
    @PostMapping
    public order createOrder(@RequestBody order newOrder) {
        return orderRepository.save(newOrder);
    }

    // ✅ Update order
    @PutMapping("/{id}")
    public order updateOrder(@PathVariable Integer id, @RequestBody order updated) {
        order existing = orderRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setCustomerName(updated.getCustomerName());
            existing.setAddress(updated.getAddress());
            existing.setContactNumber(updated.getContactNumber());
            existing.setOrderDate(updated.getOrderDate());
            existing.setSofaType(updated.getSofaType());
            existing.setQuantity(updated.getQuantity());
            existing.setStatus(updated.getStatus());
            existing.setExpectedDelivery(updated.getExpectedDelivery());
            existing.setNotes(updated.getNotes());

            order saved = orderRepository.save(existing);

            // ✅ If status = completed, insert into completed_orders
            if (updated.getStatus() == Status.completed) {
                CompletedOrder completedOrder = new CompletedOrder(
                        saved.getId(),
                        saved.getCustomerName(),
                        saved.getAddress(),
                        saved.getContactNumber(),
                        saved.getOrderDate(),
                        saved.getSofaType(),
                        saved.getQuantity(),
                        saved.getExpectedDelivery(),
                        saved.getNotes(),
                        new Date(System.currentTimeMillis()) // today's date
                );

                completedOrderRepository.save(completedOrder);
            }

            return saved;
        }
        return null;
    }
    


    // ✅ Delete order
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orderRepository.deleteById(id);
    }
}
