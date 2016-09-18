package com.senac.cl.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.senac.cl.modelos.LeituraHistorico;

/**
 * 
 * @author Pedro
 * @since 18/09/2016
 */
@SuppressWarnings(value = "all")
public class LeituraHistoricoRepository {

	@Inject
	protected EntityManager entityManager;

	public void inserir(LeituraHistorico ed) {
		entityManager.persist(ed);
	}

	public void atualizar(LeituraHistorico ed) {
		entityManager.merge(ed);
	}

	public void deletar(LeituraHistorico ed) {
		entityManager.remove(ed);
	}

	public List<LeituraHistorico> todosOsRegistros() {
		return entityManager.createQuery("select l from " + LeituraHistorico.class.getSimpleName() + " l").getResultList();
	}

}
