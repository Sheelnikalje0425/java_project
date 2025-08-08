package com.erp.businessmanagement.entity;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "work_assignments")
public class WorkAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(
        name = "assignment_workers",
        joinColumns = @JoinColumn(name = "assignment_id"),
        inverseJoinColumns = @JoinColumn(name = "worker_id")
    )
    private List<Worker> workers = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "order_id")
    private order order;

    @Column(name = "assign_date")
    private Date assignDate;

    @ManyToOne
    @JoinColumn(name = "fabric_id")
    private fabrics fabric;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private SofaModel model;

    @ManyToOne
    @JoinColumn(name = "design_id")
    private sofa_designs design;

    @Column(name = "exp_comp_date")
    private Date expCompDate;

    @Column(columnDefinition = "TEXT")
    private String instruction;

    // --- Getters and Setters ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public order getOrder() {
        return order;
    }

    public void setOrder(order order) {
        this.order = order;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public fabrics getFabric() {
        return fabric;
    }

    public void setFabric(fabrics fabric) {
        this.fabric = fabric;
    }

    public SofaModel getModel() {
        return model;
    }

    public void setModel(SofaModel model) {
        this.model = model;
    }

    public sofa_designs getDesign() {
        return design;
    }

    public void setDesign(sofa_designs design) {
        this.design = design;
    }

    public Date getExpCompDate() {
        return expCompDate;
    }

    public void setExpCompDate(Date expCompDate) {
        this.expCompDate = expCompDate;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
