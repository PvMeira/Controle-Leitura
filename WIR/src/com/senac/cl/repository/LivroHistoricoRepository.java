package com.senac.cl.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.senac.cl.modelos.LivroHistorico;
/**
 * 
 * @author Pedro
 * @since 25/09/2016
 */
@SuppressWarnings(value = "all")
public class LivroHistoricoRepository {

	@Inject
	protected EntityManager entityManager;

	public void inserir(LivroHistorico ed) {
		entityManager.persist(ed);
	}

	public void atualizar(LivroHistorico ed) {
		entityManager.merge(ed);
	}

	public void deletar(LivroHistorico ed) {
		entityManager.remove(ed);
	}

	public List<LivroHistorico> todosOsRegistros() {
		return entityManager.createQuery("select l from " + LivroHistorico.class.getSimpleName() + " l").getResultList();
	}

}
