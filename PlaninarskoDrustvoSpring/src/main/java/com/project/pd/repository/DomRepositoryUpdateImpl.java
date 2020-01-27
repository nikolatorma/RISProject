package com.project.pd.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.DomNT;

@Repository
@Transactional
public class DomRepositoryUpdateImpl implements DomRepositoryUpdate{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public boolean smanjiBrojSlobodnihMestaUDomu(DomNT d) {
		
		int upit = em.createQuery("UPDATE DomNT SET brojSlobodnihMesta=:brojSlobodnihMesta WHERE idDom=:idDom").setParameter("brojSlobodnihMesta", d.getBrojSlobodnihMesta()-1).setParameter("idDom", d.getIdDom()).executeUpdate();
		if(upit != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean povecajBrojSlobodnihMestaUDomu(DomNT d) {
		
		int upit = em.createQuery("UPDATE DomNT SET brojSlobodnihMesta=:brojSlobodnihMesta WHERE idDom=:idDom").setParameter("brojSlobodnihMesta", d.getBrojSlobodnihMesta()+1).setParameter("idDom", d.getIdDom()).executeUpdate();
		if(upit != 0) {
			return true;
		}
		return false;
	}

}
