package com.senac.cl.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.senac.cl.modelos.Pessoa;

@SuppressWarnings("all")
public class PessoaRepository {

	@Inject
	private EntityManager entityManager;

	public void inserir(Pessoa pessoa) {
		entityManager.persist(pessoa);
	}

	public List<Pessoa> todasAsPessoas() {
		return entityManager.createQuery("select l from " + Pessoa.class.getSimpleName() + " l").getResultList();
	}

	public void remover(Pessoa pessoa) {
		entityManager.remove(entityManager.merge(pessoa));
	}

	public void removerPeloId(Integer id) {
		Pessoa entity = entityManager.find(Pessoa.class, id);
		entityManager.remove(entity);
	}

	public void atualizar(Pessoa pessoa) {
		entityManager.merge(pessoa);
	}

	public Pessoa buscarPeloId(Integer id) {
		return entityManager.find(Pessoa.class, id);
	}

}