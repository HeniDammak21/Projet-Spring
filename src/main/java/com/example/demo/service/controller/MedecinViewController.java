package com.example.demo.service.controller;
import com.example.demo.persistance.entities.Medecin;
import com.example.demo.service.impliments.MedecinService;
import com.example.demo.service.impliments.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
@Controller
public class MedecinViewController {
    @Autowired
    private MedecinService medecinService;
    @Autowired
    private SpecialityService specialiteService;
    @GetMapping("/medecins")
    public String viewHomePage(Model model) {
        model.addAttribute("listMedecins", medecinService.getListMedecin());
        return "medecins";}
    @GetMapping("/add-medecin")
    public String showAdd(Model model) {
        model.addAttribute("medecin", new Medecin());
        model.addAttribute("listeSpecialite",specialiteService.getListSpeciality());
        return "add-new-medecin";
    }
    @GetMapping("/edit-medecin/{id}")
    public String showEdit(@ModelAttribute("medecin") Medecin medecin, Model model) {
        model.addAttribute("medecin", medecinService.getMedecin(medecin.getId()));
        model.addAttribute("listeSpecialite", specialiteService.getListSpeciality());
        return "edit-medecin";
    }
    @GetMapping("/view-medecin/{id}")
    public String view(@ModelAttribute("medecin") Medecin medecin, Model model) {
        model.addAttribute("medecin", medecinService.getMedecin(medecin.getId()));
        model.addAttribute("listeSpecialite",specialiteService.getListSpeciality());
        return "view-medecin";
    }
}