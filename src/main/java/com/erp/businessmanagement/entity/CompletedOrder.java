package com.erp.businessmanagement.entity;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "completed_orders")
public class CompletedOrder {

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOriginalOrderId() {
		return originalOrderId;
	}

	public void setOriginalOrderId(Integer originalOrderId) {
		this.originalOrderId = originalOrderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getSofaType() {
		return sofaType;
	}

	public void setSofaType(String sofaType) {
		this.sofaType = sofaType;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getExpectedDelivery() {
		return expectedDelivery;
	}

	public void setExpectedDelivery(Date expectedDelivery) {
		this.expectedDelivery = expectedDelivery;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "original_order_id")
    private Integer originalOrderId;

    private String customerName;
    private String address;
    private String contactNumber;
    private Date orderDate;
    private String sofaType;
    private Integer quantity;
    private Date expectedDelivery;
    private String notes;
    private Date completionDate;

    // 🔃 Constructors
    public CompletedOrder() {}

    public CompletedOrder(Integer originalOrderId, String customerName, String address, String contactNumber,
                          Date orderDate, String sofaType, Integer quantity, Date expectedDelivery,
                          String notes, Date completionDate) {
        this.originalOrderId = originalOrderId;
        this.customerName = customerName;
        this.address = address;
        this.contactNumber = contactNumber;
        this.orderDate = orderDate;
        this.sofaType = sofaType;
        this.quantity = quantity;
        this.expectedDelivery = expectedDelivery;
        this.notes = notes;
        this.completionDate = completionDate;
    }

    // ✅ Getters & Setters (generate karun ghe)
}
