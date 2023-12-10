package com.example.demo.service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.persistance.entities.Speciality;
import com.example.demo.service.interfaces.ISpeciality;

import java.util.List;

@Controller
@RequestMapping("/api/speciality")
public class SpecialityController {

	@Autowired
	ISpeciality specialityservice;


	@PostMapping(consumes = "application/x-www-form-urlencoded")
	String save(@ModelAttribute Speciality speciality) {
		System.out.println("*******save ***********");
		Speciality savedSp = specialityservice.saveSpeciality(speciality);

		System.out.println("Saved Patient Email: " + savedSp.getSpecialityName());
		return "redirect:/specialities";
	}
	@PutMapping("/{id}")
	String updatePatient(@ModelAttribute Speciality sp) {
		System.out.println("*******update ***********");
		specialityservice.updateSpeciality(sp);
		return "redirect:/specialities";
	}

	@GetMapping("/{id}")
	Speciality getSpById(@PathVariable Long id) {
		return specialityservice.getSpecialityByIdSpeciality(id);
	}

	@DeleteMapping("/delete/{id}")
	String delete(@PathVariable Long id) {
		specialityservice.deleteSpeciality(id);
		return "redirect:/specialities";
	}
	@GetMapping("/list")
	List<Speciality> getAllPatient() {
		return specialityservice.getListSpeciality();
	}

	
	
}
