package com.example.demo.service.controller;

import com.example.demo.persistance.entities.Medecin;
import com.example.demo.persistance.entities.Speciality;
import com.example.demo.service.impliments.MedecinService;
import com.example.demo.service.impliments.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SpecialityViewController {

    @Autowired
    private SpecialityService specialityService;

    @GetMapping("/specialities")
    public String viewHomePage(Model model) {
        model.addAttribute("listSp", specialityService.getListSpeciality());
        return "specialites";
    }
    @GetMapping("/add-speciality")
    public String showAdd(Model model) {
        model.addAttribute("sp", new Speciality());
        return "add-new-speciality";
    }
    @GetMapping("/edit-speciality/{id}")
    public String showEdit(@ModelAttribute("sp") Speciality sp, Model model) {
        model.addAttribute("sp", specialityService.getSpeciality(sp.getId()));
        return "edit-speciality";
    }

    @GetMapping("/view-speciality/{id}")
    public String view(@ModelAttribute("sp") Speciality speciality, Model model) {
        model.addAttribute("sp", specialityService.getSpeciality(speciality.getId()));
        return "view-speciality";
    }
}
