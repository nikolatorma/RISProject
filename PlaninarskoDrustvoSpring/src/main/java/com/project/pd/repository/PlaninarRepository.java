package com.project.pd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.PlaninarNT;

public interface PlaninarRepository extends JpaRepository<PlaninarNT, Integer>{

	@Query("SELECT p FROM PlaninarNT p WHERE p.korisnickoPlaninar=:korisnickoPlaninar and p.sifraPlaninara=:sifraPlaninara")
	public PlaninarNT findByKorisnickoPlaninarSifraPlaninara(@Param("korisnickoPlaninar")String korisnickoPlaninar, @Param("sifraPlaninara") String sifraPlaninara);
	
	public PlaninarNT findByKorisnickoPlaninar(String korisnickoPlaninar);
}
