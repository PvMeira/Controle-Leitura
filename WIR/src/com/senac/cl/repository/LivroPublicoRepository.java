package com.senac.cl.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.senac.cl.modelos.LivroPublico;

/**
 * 
 * @author Pedro
 * @since 25/09/2016
 */
public class LivroPublicoRepository {

	@Inject
	protected EntityManager entityManager;

	/**
	 * Inserir
	 * @param livro
	 */
	public void inserir(LivroPublico livro) {
		entityManager.persist(livro);

	}

	/**
	 * Deletar
	 * @param livro
	 */
	public void deletar(LivroPublico livro) {
		entityManager.remove(entityManager.merge(livro));

	}
	


	/**
	 * Atualizar
	 * @param livro
	 */
	public void atualizar(LivroPublico livro) {
		entityManager.merge(livro);

	}

	/**
	 * Lista todos os registros
	 * @return
	 */
	@SuppressWarnings(value = { "all" })
	public List<LivroPublico> todosOsRegistros() {
		return entityManager.createQuery("select l from " + LivroPublico.class.getSimpleName() + " l").getResultList();
	}
}
