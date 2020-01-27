package com.project.pd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.DomNT;
import model.PlaninaNT;

public interface DomRepository extends JpaRepository<DomNT, Integer>, DomRepositoryUpdate{

	List<DomNT> findByPlaninaNt(PlaninaNT p);
}
