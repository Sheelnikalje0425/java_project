package com.erp.businessmanagement.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "sofa_models")
public class SofaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelName;
    private String material;
    private Double price;

    // This maps to WorkAssignment.sofaModel
    @OneToMany(mappedBy = "sofaModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WorkAssignment> assignments;

    // Constructors
    public SofaModel() {}

    public SofaModel(Long id) {
        this.id = id;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    /*public List<WorkAssignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<WorkAssignment> assignments) {
        this.assignments = assignments;
    }*/
}
