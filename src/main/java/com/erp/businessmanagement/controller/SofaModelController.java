package com.erp.businessmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.erp.businessmanagement.entity.SofaModel;
import com.erp.businessmanagement.repository.SofaModelRepository;

@RestController
@RequestMapping("/api/sofa-models")  // Base path for models
@CrossOrigin(origins = "http://localhost:3000")
public class SofaModelController {

    @Autowired
    private SofaModelRepository sofaModelRepository;

    // ✅ GET all sofa models
    @GetMapping
    public List<SofaModel> getAllSofaModels() {
        return sofaModelRepository.findAll();
    }

    // ✅ POST a new sofa model
    @PostMapping
    public SofaModel createSofaModel(@RequestBody SofaModel model) {
        return sofaModelRepository.save(model);
    }
}
