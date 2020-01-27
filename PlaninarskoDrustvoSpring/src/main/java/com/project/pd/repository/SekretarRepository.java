package com.project.pd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.SekretarNT;

public interface SekretarRepository extends JpaRepository<SekretarNT, Integer>{

	@Query("SELECT s FROM SekretarNT s WHERE s.korisnickoSekretara=:korisnickoSekretara and s.sifraSekretara=:sifraSekretara")
	public SekretarNT findByKorisnickoSekretaraSifraSekretara(@Param("korisnickoSekretara")String korisnickoSekretara, @Param("sifraSekretara") String sifraSekretara);
	
	public SekretarNT findByKorisnickoSekretara(String korisnickoSekretara);
}
