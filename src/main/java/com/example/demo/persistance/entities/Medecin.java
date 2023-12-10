package com.example.demo.persistance.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Medecin implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String nom;
    private String prenom;
    
    public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Rendezvous> getListrdv() {
		return Listrdv;
	}
	public void setListrdv(List<Rendezvous> listrdv) {
		Listrdv = listrdv;
	}
	public Speciality getSpecialities() {
		return specialities;
	}
	public void setSpecialities(Speciality specialities) {
		this.specialities = specialities;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	private String email;
    @OneToMany(mappedBy = "medecin")
    @JsonIgnore
    private List<Rendezvous> Listrdv;
    @ManyToOne
    private Speciality specialities;
    private String address;
}

