package com.example.demo.service.controller;

import com.example.demo.persistance.entities.Consultation;

import com.example.demo.service.interfaces.IConsultation;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/api/consultation")
public class ConsultationController {


	@Autowired
	IConsultation consultationService;

	@PostMapping(consumes = "application/x-www-form-urlencoded")
	String save(@ModelAttribute Consultation cons) {
		System.out.println("*******save ***********");
		Consultation saved = consultationService.saveConsultation(cons);

		System.out.println("Saved Consultation Email: " + saved.getId());
		return "redirect:/consultations";
	}
	@PutMapping("/{id}")
	String update(@ModelAttribute Consultation cons) {
		System.out.println("*******update ***********");
		consultationService.updateConsultation(cons);
		return "redirect:/consultations";
	}

	@GetMapping("/{id}")
	Consultation getById(@PathVariable Long id) {
		return consultationService.getConsultation(id);
	}


	@DeleteMapping("/delete/{id}")
	String delete(@PathVariable Long id) {
		consultationService.deleteConsultation(id);
		return "redirect:/consultations";
	}
	@GetMapping("/list")
	List<Consultation> getAllConsultation() {
		return consultationService.getListConsultation();
	}

}
