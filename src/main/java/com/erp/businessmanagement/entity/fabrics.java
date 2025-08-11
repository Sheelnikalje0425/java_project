package com.erp.businessmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fabrics")
public class fabrics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fabric_type", nullable = false)
    private String fabricType;

    // 👉 Constructors
    public fabrics() {}
    
    public fabrics(Integer id) {
        this.id = id;
    }

    public fabrics(Integer id, String fabricType) {
        this.id = id;
        this.fabricType = fabricType;
    }

    // 👉 Getters & Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFabricType() {
        return fabricType;
    }

    public void setFabricType(String fabricType) {
        this.fabricType = fabricType;
    }

    // 👉 Optional: toString()
    @Override
    public String toString() {
        return "fabrics{" +
                "id=" + id +
                ", fabricType='" + fabricType + '\'' +
                '}';
    }
}
