package com.erp.businessmanagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sofa_designs")
public class sofa_designs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "photo_path", nullable = false)
    private String photoPath;

    @ManyToOne
    @JoinColumn(name = "sofa_model_id", nullable = false)
    private SofaModel sofaModel;

    // 👉 Constructors
    public sofa_designs() {
    }

    public sofa_designs(Integer id, String photoPath, SofaModel sofaModel) {
        this.id = id;
        this.photoPath = photoPath;
        this.sofaModel = sofaModel;
    }

    // 👉 Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public SofaModel getSofaModel() {
        return sofaModel;
    }

    public void setSofaModel(SofaModel sofaModel) {
        this.sofaModel = sofaModel;
    }
}
