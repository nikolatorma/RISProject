package com.project.pd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.PlaninaNT;
import model.PlaninarNT;
import model.PostNT;

public interface PostRepository extends JpaRepository<PostNT, Integer>{

	List<PostNT> findByPlaninarNt(PlaninarNT p);
	List<PostNT> findByPlaninaNt(PlaninaNT p);
}
