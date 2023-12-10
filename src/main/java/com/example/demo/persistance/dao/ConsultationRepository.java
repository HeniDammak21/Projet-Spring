package com.example.demo.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.persistance.entities.Consultation;
public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
	
	//Consultation findByNom(String nom);
	

    @Query(value = "select count(*) from consultation",nativeQuery = true)
    int getQuantityOfConsultation();
    @Query(value = "select * from patient where id= :id",nativeQuery = true)
    Consultation getConsultationByIdConsultation(@Param("id") Long id);

}