package com.senac.cl.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;

import com.senac.cl.modelos.Pessoa;
/**
 *  @author Pedro
 *  @since 27/08/2016
 */
@SuppressWarnings("all")
public class PessoaRepository {

	@Inject
	private EntityManager entityManager;
/**
 * Faz o insert da entidade no Banco
 * @param pessoa
 */
	public void inserir(Pessoa pessoa) {
		pessoa.setNormal(true);
		entityManager.persist(pessoa);
	}
/**
 * Lista todos os itens da entidade do banco
 * @return
 */
	public List<Pessoa> todasAsPessoas() {
		return entityManager.createQuery("select l from " + Pessoa.class.getSimpleName() + " l").getResultList();
	}
/**
 * Remove a entidade do banco
 * @param pessoa
 */
	public void remover(Pessoa pessoa) {
		entityManager.remove(entityManager.merge(pessoa));
	}
/**
 * Remove entidade pelo seu Id do banco
 * @param id
 */
	public void removerPeloId(Integer id) {
		Pessoa entity = entityManager.find(Pessoa.class, id);
		entityManager.remove(entity);
	}
/**
 * Atualiza entidade 
 * @param pessoa
 */
	public void atualizar(Pessoa pessoa) {
		entityManager.merge(pessoa);
	}
/**
 * Busca Entidade pelo seu ID do banco
 * @param id
 * @return
 */
	public Pessoa buscarPeloId(Integer id) {
		return entityManager.find(Pessoa.class, id);
	}
	
}
