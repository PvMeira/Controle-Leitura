package com.senac.cl.fabricas;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@ApplicationScoped
public class FabricaDeEntityManager {

	private static javax.persistence.EntityManagerFactory fabrica = Persistence
			.createEntityManagerFactory("WhatIamReadingUnit");

	@Produces
	@RequestScoped
	public EntityManager createEntityManager() {
		return fabrica.createEntityManager();
	}

	public void closeEntityManager(@Disposes EntityManager manager) {
		manager.close();
	}
}
