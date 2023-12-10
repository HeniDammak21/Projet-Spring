package com.example.demo.persistance.dao;

import com.example.demo.persistance.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
	
	Medecin findByNom(String nom);

    @Query(value = "select * from medecin where id= :id",nativeQuery = true)
    Medecin getPatientByIdPatient(@Param("id") Long id);

}


