package com.example.demo.service.controller;

import com.example.demo.persistance.entities.Consultation;
import com.example.demo.persistance.entities.Medecin;
import com.example.demo.persistance.entities.Rendezvous;
import com.example.demo.service.impliments.ConsultationService;
import com.example.demo.service.impliments.MedecinService;
import com.example.demo.service.impliments.PatientService;
import com.example.demo.service.impliments.RendezvousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class RendezVousViewController {

    @Autowired
    private RendezvousService rendezvousService;
    @Autowired
    private MedecinService medecinService;
    @Autowired
    private PatientService patientService;

    @GetMapping("/rendezvous")
    public String viewHomePage(Model model) {
        model.addAttribute("listRdv", rendezvousService.getListRendezvous());
        return "rendezvous";
    }
    @GetMapping("/add-rdv")
    public String showAddForm(Model model) {
        model.addAttribute("rdv", new Rendezvous());
        model.addAttribute("ListeMedecins", medecinService.getListMedecin());
        model.addAttribute("listePatients", patientService.getListPatient());
        return "add-new-rdv";
    }
    @GetMapping("/edit-rdv/{id}")
    public String showEditPatientForm(@ModelAttribute("patient") Rendezvous rdv, Model model) {
        model.addAttribute("consultation", rendezvousService.getRendezvous(rdv.getId()));
        model.addAttribute("rdv", rendezvousService.getRendezvous(rdv.getId()));
        model.addAttribute("ListeMedecins", medecinService.getListMedecin());
        model.addAttribute("listePatients", patientService.getListPatient());
        return "edit-rdv";
    }

    @GetMapping("/view-rdv/{id}")
    public String viewPatient(@ModelAttribute("consultation") Rendezvous rdv, Model model) {
        model.addAttribute("consultation", rendezvousService.getRendezvous(rdv.getId()));
        model.addAttribute("rdv", rendezvousService.getRendezvous(rdv.getId()));
        model.addAttribute("ListeMedecins", medecinService.getListMedecin());
        model.addAttribute("listePatients", patientService.getListPatient());
        return "view-rdv";
    }
   

}
