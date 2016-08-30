package com.senac.cl.fabricas;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
/**
 * 
 * @author Pedro
 * @since 27/08/2016
 */

/**
 *@CLASS Fabrica de Entity Manager, cria uma instancia de EntityManager para Toda a aplicação
 *Evitando de cada vez que seja necessário um EM, criesse.
 *
 */
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
