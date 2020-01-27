package com.project.pd.repository;

import model.DomNT;

public interface DomRepositoryUpdate {

	boolean smanjiBrojSlobodnihMestaUDomu(DomNT d);
	boolean povecajBrojSlobodnihMestaUDomu(DomNT d);
}
