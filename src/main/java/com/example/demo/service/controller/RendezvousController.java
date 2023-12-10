package com.example.demo.service.controller;

import com.example.demo.persistance.entities.Rendezvous;
import com.example.demo.persistance.entities.Speciality;
import com.example.demo.service.interfaces.IRendezvous;
import com.example.demo.service.interfaces.ISpeciality;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/api/rendezvous")
public class RendezvousController {

	@Autowired
	IRendezvous rendezvousService;


	@PostMapping(consumes = "application/x-www-form-urlencoded")
	String save(@ModelAttribute Rendezvous rdv) {
		System.out.println("*******save ***********");
		Rendezvous savedRdv = rendezvousService.saveRendezvous(rdv);

		System.out.println("Saved Patient Email: " + savedRdv.getId());
		return "redirect:/rendezvous";
	}
	@PutMapping("/{id}")
	String updatePatient(@ModelAttribute Rendezvous rdv) {
		System.out.println("*******update ***********");
		rendezvousService.updateRendezvous(rdv);
		return "redirect:/rendezvous";
	}

	@GetMapping("/{id}")
	Rendezvous getSpById(@PathVariable Long id) {
		return rendezvousService.getRendezvousByIdRendezvous(id);
	}

	@DeleteMapping("/delete/{id}")
	String delete(@PathVariable Long id) {
		rendezvousService.deleteRendezvous(id);
		return "redirect:/rendezvous";
	}
	@GetMapping("/list")
	List<Rendezvous> getAllPatient() {
		return rendezvousService.getListRendezvous();
	}



}
