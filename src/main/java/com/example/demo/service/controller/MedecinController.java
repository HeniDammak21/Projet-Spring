package com.example.demo.service.controller;
import com.example.demo.persistance.entities.Medecin;
import com.example.demo.service.interfaces.IMedecin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/medecin")
public class MedecinController {
	@Autowired
    IMedecin medecinservice;
    @PostMapping(consumes = "application/x-www-form-urlencoded")
    String save(@ModelAttribute Medecin medecin) {
        System.out.println("*******save ***********");
        Medecin savedMedecin = medecinservice.saveMedecin(medecin);

        System.out.println("Saved Medecin Email: " + savedMedecin.getEmail());
        return "redirect:/medecins";
    }
    @PutMapping("/{id}")
    String updateMedecin(@ModelAttribute Medecin medecin) {
        System.out.println("*******update ***********");
         medecinservice.updateMedecin(medecin);
        return "redirect:/medecins";
    }

    @GetMapping("/{id}")
    Medecin getMedecinById(@PathVariable Long id) {
        return medecinservice.getMedecin(id);
    }
	

	@GetMapping("/medecinByName/{name}")
    Medecin getMedecinByName(@PathVariable String name) {
        return medecinservice.findMedecinByName(name);
    }
	
	@DeleteMapping("/delete/{id}")
    String delete(@PathVariable Long id) {
        medecinservice.deleteMedecin(id);
        return "redirect:/medecins";
    }
    @GetMapping("/list")
    List<Medecin> getAllMedecin() {
        return medecinservice.getListMedecin();
    }
}


