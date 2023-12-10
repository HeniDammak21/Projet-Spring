package com.example.demo.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.demo.persistance.entities.Patient;
import com.example.demo.service.interfaces.IPatient;

@Controller
@RequestMapping("/api/patient")
public class PatientController {

	@Autowired
	IPatient patientservice;

    @PostMapping(consumes = "application/x-www-form-urlencoded")
    String save(@ModelAttribute Patient patient) {
        System.out.println("*******save ***********");
        Patient savedPatient = patientservice.savePatient(patient);

        System.out.println("Saved Patient Email: " + savedPatient.getEmail());
        return "redirect:/patients";
    }
    @PutMapping("/{id}")
    String updatePatient(@ModelAttribute Patient patient) {
        System.out.println("*******update ***********");
         patientservice.updatePatient(patient);
        return "redirect:/patients";
    }

    @GetMapping("/{id}")
    Patient getPatientById(@PathVariable Long id) {
        return patientservice.getPatient(id);
    }
	
	@GetMapping("/quantity")
    int getQuantityPatient() {
        return patientservice.getQuantityOfPatient();
    }
	
	@GetMapping("/patientByName/{name}")
    Patient getPatientByName(@PathVariable String name) {
        return patientservice.findPatientByName(name);
    }
	
	@DeleteMapping("/delete/{id}")
    String delete(@PathVariable Long id) {
        patientservice.deletePatient(id);
        return "redirect:/patients";
    }
    @GetMapping("/list")
    List<Patient> getAllPatient() {
        return patientservice.getListPatient();
    }


}


