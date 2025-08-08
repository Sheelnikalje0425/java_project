package com.erp.businessmanagement.controller;

import com.erp.businessmanagement.entity.fabrics;
import com.erp.businessmanagement.repository.fabricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fabrics")
@CrossOrigin(origins = "http://localhost:3000")
public class fabricsController {

    @Autowired
    private fabricsRepository fabricsRepository;

    // ✅ Get all fabrics
    @GetMapping
    public List<fabrics> getAllFabrics() {
        return fabricsRepository.findAll();
    }

    // ✅ Add new fabric
    @PostMapping
    public fabrics addFabric(@RequestBody fabrics fabric) {
        return fabricsRepository.save(fabric);
    }

    // ✅ Get fabric by ID
    @GetMapping("/{id}")
    public fabrics getFabricById(@PathVariable Integer id) {
        return fabricsRepository.findById(id).orElse(null);
    }

    // ✅ Update fabric
    @PutMapping("/{id}")
    public fabrics updateFabric(@PathVariable Integer id, @RequestBody fabrics updatedFabric) {
        fabrics existing = fabricsRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setFabricType(updatedFabric.getFabricType());
            return fabricsRepository.save(existing);
        }
        return null;
    }

    // ✅ Delete fabric
    @DeleteMapping("/{id}")
    public void deleteFabric(@PathVariable Integer id) {
        fabricsRepository.deleteById(id);
    }
}
