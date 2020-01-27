package com.project.pd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.PlaninaNT;
import model.StazaNT;

public interface StazaRepository extends JpaRepository<StazaNT, Integer>{

	List<StazaNT> findByPlaninaNt(PlaninaNT p);
}
