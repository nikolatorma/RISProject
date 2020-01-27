package com.project.pd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.StazaNT;
import model.ZnamenitostNT;

public interface ZnamenitostRepository extends JpaRepository<ZnamenitostNT, Integer>{

	List<ZnamenitostNT> findByStazaNt(StazaNT s);
}
