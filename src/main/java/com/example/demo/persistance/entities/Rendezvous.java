package com.example.demo.persistance.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Rendezvous implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateRDV;
    private String heureRDV;
    @OneToOne
    @JsonIgnore
    private Consultation consultation;
    @ManyToOne
    private Patient patient;
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDateRDV() {
		return dateRDV;
	}
	public void setDateRDV(String dateRDV) {
		this.dateRDV = dateRDV;
	}
	public String getHeureRDV() {
		return heureRDV;
	}
	public void setHeureRDV(String heureRDV) {
		this.heureRDV = heureRDV;
	}
	public Consultation getConsultation() {
		return consultation;
	}
	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Medecin getMedecin() {
		return medecin;
	}
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	@ManyToOne
    private Medecin medecin;
}