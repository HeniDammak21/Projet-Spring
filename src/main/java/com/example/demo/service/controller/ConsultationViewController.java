package com.example.demo.service.controller;

import com.example.demo.persistance.entities.Consultation;
import com.example.demo.persistance.entities.Patient;
import com.example.demo.service.impliments.ConsultationService;
import com.example.demo.service.impliments.PatientService;
import com.example.demo.service.impliments.RendezvousService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class ConsultationViewController {

    @Autowired
    private ConsultationService consultationService;
    @Autowired
    private RendezvousService rendezvousService;

    @GetMapping("/consultations")
    public String viewHomePage(Model model) {
        model.addAttribute("listCons", consultationService.getListConsultation());
        return "consultations";
    }
    @GetMapping("/add-consultation")
    public String showAddForm(Model model) {
        model.addAttribute("consultation", new Consultation());
        model.addAttribute("listerendezvous", rendezvousService.getListRendezvous());
        return "add-new-consultation";
    }
    @GetMapping("/edit-consultation/{id}")
    public String showEditPatientForm(@ModelAttribute("consultation") Consultation cons, Model model) {
        model.addAttribute("consultation", consultationService.getConsultation(cons.getId()));
        model.addAttribute("listerendezvous", rendezvousService.getListRendezvous());
        return "edit-consultation";
    }

    @GetMapping("/view-consultation/{id}")
    public String viewPatient(@ModelAttribute("consultation") Consultation cons, Model model) {
        model.addAttribute("consultation", consultationService.getConsultation(cons.getId()));
        model.addAttribute("listerendezvous", rendezvousService.getListRendezvous());
        return "view-consultation";
    }


}
