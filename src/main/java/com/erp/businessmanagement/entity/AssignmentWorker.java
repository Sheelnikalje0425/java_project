package com.erp.businessmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "assignment_workers")
public class AssignmentWorker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Many-to-One with WorkAssignment
    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private WorkAssignment assignment;

    // Many-to-One with Worker
    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    // Constructors
    public AssignmentWorker() {
    }

    public AssignmentWorker(WorkAssignment assignment, Worker worker) {
        this.assignment = assignment;
        this.worker = worker;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WorkAssignment getAssignment() {
        return assignment;
    }

    public void setAssignment(WorkAssignment assignment) {
        this.assignment = assignment;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
