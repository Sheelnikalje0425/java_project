package com.erp.businessmanagement.entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "orders")
public class order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    private String address;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "sofa_type")
    private String sofaType;

    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "expected_delivery")
    private Date expectedDelivery;

    private String notes;

    public enum Status {
        in_progress, completed, cancelled
    }

    // 👉 Constructors
    public order() {}

    public order(Integer id) {
        this.id = id;
    }
    
    public order(Integer id, String customerName, String address, String contactNumber, Date orderDate,
                 String sofaType, Integer quantity, Status status, Date expectedDelivery, String notes) {
        this.id = id;
        this.customerName = customerName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.orderDate = orderDate;
        this.sofaType = sofaType;
        this.quantity = quantity;
        this.status = status;
        this.expectedDelivery = expectedDelivery;
        this.notes = notes;
    }

    // 👉 Getters and Setters (can generate via IDE)
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public String getSofaType() { return sofaType; }
    public void setSofaType(String sofaType) { this.sofaType = sofaType; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Date getExpectedDelivery() { return expectedDelivery; }
    public void setExpectedDelivery(Date expectedDelivery) { this.expectedDelivery = expectedDelivery; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
