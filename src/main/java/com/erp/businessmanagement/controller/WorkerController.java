package com.erp.businessmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.businessmanagement.entity.Worker;
import com.erp.businessmanagement.repository.WorkerRepository;

@RestController()
@RequestMapping("/api/workers")
@CrossOrigin(origins = "http://localhost:3000")
public class WorkerController {
	
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping
	public List<Worker> getAllWorkers(){
		return workerRepository.findAll();
	}
	
	@PostMapping
	public Worker createWorker(@RequestBody Worker worker) {
		return workerRepository.save(worker);
	}
	
	@GetMapping("/{id}")
	public Worker getWorkerById(@PathVariable Integer id) {
		return workerRepository.findById(id).orElse(null);
	}
	
	@PutMapping("/{id}")
    public Worker updateWorker(@PathVariable Integer id, @RequestBody Worker updated) {
        Worker existing = workerRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(updated.getName());
            existing.setContactNumber(updated.getContactNumber());
            existing.setAddress(updated.getAddress());
            existing.setAadharNumber(updated.getAadharNumber());
            existing.setSkillType(updated.getSkillType());
            existing.setRatePerSofa(updated.getRatePerSofa());
            existing.setJoiningDate(updated.getJoiningDate());
            existing.setIsActive(updated.getIsActive());
            return workerRepository.save(existing);       
        }
        return null;
        
    }

    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable Integer id) {
        workerRepository.deleteById(id);
    }
}

