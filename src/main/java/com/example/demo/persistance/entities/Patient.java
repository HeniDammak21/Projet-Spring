package com.example.demo.persistance.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Patient implements Serializable{

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

	public List<Rendezvous> getRendezvousList() {
		return rendezvousList;
	}
	public void setRendezvousList(List<Rendezvous> rendezvousList) {
		this.rendezvousList = rendezvousList;
	}
	@Id 
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  private String nom;
	  private String prenom;
	  public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	private String email;
	  private String address;
	  public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@JsonIgnore
	  @OneToMany(mappedBy="patient",fetch=FetchType.LAZY)
	  private List<Rendezvous>rendezvousList;

}
