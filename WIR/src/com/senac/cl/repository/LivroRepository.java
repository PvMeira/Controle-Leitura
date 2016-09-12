package com.senac.cl.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import com.senac.cl.modelos.Livro;
@SuppressWarnings(value ="all")
public class LivroRepository {

	@Inject
	protected EntityManager entityManager;

	public void inserir(Livro livro) {
		entityManager.persist(livro);

	}

	public void deletar(Livro livro) {
		entityManager.remove(entityManager.merge(livro));

	}

	public void atualizar(Livro livro) {
		entityManager.merge(livro);

	}

	@SuppressWarnings(value = { "all" })
	public List<Livro> todosOsRegistros() {
		return entityManager.createQuery("select l from " + Livro.class.getSimpleName() + " l").getResultList();
	}

	/**
	 * Retorna Lista com todos os livros registrados do usuario logado
	 * 
	 * @param id
	 * @return
	 */
	public List<Livro> todosOsRegistrosDoUsuario(Long id) {
		String sql = "SELECT * FROM livro WHERE id_pessoa = " + id + ";";
		return entityManager.createNativeQuery(sql, Livro.class).getResultList();
	}
	
	/**
	 * Query para o auto Complete 
	 * @param s
	 * @return
	 */
	public List<Livro> listarLivrosAutoComplete(String s){
		String sql = "SELECT * FROM livro where titulo LIKE "+"'"+"%"+s+"%"+"'"+";";
		return  entityManager.createNativeQuery(sql,Livro.class).getResultList();
	}
}
