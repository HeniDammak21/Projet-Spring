package com.example.demo.service.impliments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.dao.RendezvousRepository;
import com.example.demo.persistance.entities.Rendezvous;
import com.example.demo.service.interfaces.IRendezvous;

@Service
public class RendezvousService implements IRendezvous {

	@Autowired
	RendezvousRepository Rendezvousrepository;
	
	@Override
	public Rendezvous saveRendezvous(Rendezvous rendezvous) {
		// TODO Auto-generated method stub
		return Rendezvousrepository.save(rendezvous);
	}

	@Override
	public Rendezvous updateRendezvous(Rendezvous rendezvous) {
		// TODO Auto-generated method stub
		return Rendezvousrepository.saveAndFlush(rendezvous);
	}

	@Override
	public boolean deleteRendezvous(Long id) {
		// TODO Auto-generated method stub
		Rendezvousrepository.deleteById(id);
		return true;
	}

	@Override
	public List<Rendezvous> getListRendezvous() {
		// TODO Auto-generated method stub
		return  Rendezvousrepository.findAll();
	}

	@Override
	public Rendezvous getRendezvous(Long id) {
		// TODO Auto-generated method stub
		return  Rendezvousrepository.findById(id).get();
	}

	@Override
	public int getQuantityOfRendezvous() {
		// TODO Auto-generated method stub
		return  Rendezvousrepository.getQuantityOfRendezvous();
	}

	@Override
	public Rendezvous getRendezvousByIdRendezvous(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
