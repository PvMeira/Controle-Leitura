package com.senac.cl.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.senac.cl.modelos.Livro;

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
	 * @param id
	 * @return
	 */
	public List<Livro> todosOsRegistrosDoUsuario(Long id){
		String sql ="SELECT * FROM livro WHERE id_pessoa = "+id+";";
		return entityManager.createNativeQuery(sql, Livro.class).getResultList();
	}

}
