package com.project.pd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.PlaninarNT;
import model.RezervacijaNT;

public interface RezervacijaRepository extends JpaRepository<RezervacijaNT, Integer>{

	List<RezervacijaNT> findByPlaninarNt(PlaninarNT p);
}
