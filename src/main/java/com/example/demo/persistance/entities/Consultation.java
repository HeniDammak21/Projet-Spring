package com.example.demo.persistance.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Consultation implements Serializable {
	    @Id 
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String dateCons;
		private String recapCons;
	    @OneToOne
	    private Rendezvous rendezvous;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getDateCons() {
			return dateCons;
		}
		public void setDateCons(String dateCons) {
			this.dateCons = dateCons;
		}
		public String getRecapCons() {
			return recapCons;
		}
		public void setRecapCons(String recapCons) {
			this.recapCons = recapCons;
		}
		public Rendezvous getRendezvous() {
			return rendezvous;
		}
		public void setRendezvous(Rendezvous rendezvous) {
			this.rendezvous = rendezvous;
		}
	

}
