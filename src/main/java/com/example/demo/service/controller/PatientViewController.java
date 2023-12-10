package com.example.demo.service.controller;

import com.example.demo.persistance.entities.Patient;
import com.example.demo.service.impliments.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class PatientViewController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public String viewHomePage(Model model) {
        model.addAttribute("listPatients", patientService.getListPatient());
        return "patients";
    }
    @GetMapping("/add-patient")
    public String showAddPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-new-patient";
    }
    @GetMapping("/edit-patient/{id}")
    public String showEditPatientForm(@ModelAttribute("patient") Patient patient, Model model) {
        model.addAttribute("patient", patientService.getPatient(patient.getId()));
        return "edit-patient";
    }

    @GetMapping("/view-patient/{id}")
    public String viewPatient(@ModelAttribute("patient") Patient patient, Model model) {
        model.addAttribute("patient", patientService.getPatient(patient.getId()));
        return "view-patient";
    }


}
