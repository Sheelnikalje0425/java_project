package com.erp.businessmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.erp.businessmanagement.entity.sofa_designs;
import com.erp.businessmanagement.repository.sofa_designsRepository;

@RestController
@RequestMapping("/api/sofa_designs")
@CrossOrigin(origins = "http://localhost:3000")
public class sofa_designsController {

    @Autowired
    private sofa_designsRepository sofaDesignsRepository;

    // ✅ Get all sofa designs
    @GetMapping
    public List<sofa_designs> getAllSofaDesigns() {
        return sofaDesignsRepository.findAll();
    }

    // ✅ Add new sofa design
    @PostMapping
    public sofa_designs addSofaDesign(@RequestBody sofa_designs design) {
        return sofaDesignsRepository.save(design);
    }

    // ✅ Get design by ID
    @GetMapping("/{id}")
    public sofa_designs getDesignById(@PathVariable Integer id) {
        return sofaDesignsRepository.findById(id).orElse(null);
    }

    // ✅ Delete design
    @DeleteMapping("/{id}")
    public void deleteDesign(@PathVariable Integer id) {
        sofaDesignsRepository.deleteById(id);
    }
}
