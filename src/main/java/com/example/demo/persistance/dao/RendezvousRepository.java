package com.example.demo.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.persistance.entities.Rendezvous;
public interface RendezvousRepository extends JpaRepository<Rendezvous,Long> {
	

	

    @Query(value = "select count(*) from rendezvous",nativeQuery = true)
    int getQuantityOfRendezvous();
    @Query(value = "select * from rendezvous where id= :id",nativeQuery = true)
    Rendezvous getRendezvousByIdRendezvous(@Param("id") Long id);

}