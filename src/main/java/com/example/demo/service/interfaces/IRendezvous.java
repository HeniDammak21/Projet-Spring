package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.persistance.entities.Rendezvous;

public interface IRendezvous {

	Rendezvous saveRendezvous(Rendezvous rendezvous);
	Rendezvous updateRendezvous(Rendezvous rendezvous);
     boolean deleteRendezvous(Long id);
     List<Rendezvous> getListRendezvous();
     Rendezvous getRendezvous(Long id);
     int getQuantityOfRendezvous();
     Rendezvous getRendezvousByIdRendezvous(Long id);
}
