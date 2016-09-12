package com.senac.cl.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.senac.cl.modelos.Leitura;
import com.senac.cl.modelos.Livro;
import com.senac.cl.modelos.Pessoa;

/**
 * 
 * @author Pedro
 * @since 11/09/2016
 */
@SuppressWarnings(value = "all")
public class LeituraRepository {
	@Inject
	protected EntityManager entityManager;

	/**
	 * Salva
	 * 
	 * @param leitura
	 */
	public void inserir(Leitura leitura) {
		entityManager.persist(leitura);

	}

	/**
	 * deleta
	 * 
	 * @param leitura
	 */
	public void deletar(Leitura leitura) {
		entityManager.remove(entityManager.merge(leitura));

	}

	/**
	 * Atualiza
	 * 
	 * @param leitura
	 */
	public void atualizar(Leitura leitura) {
		entityManager.merge(leitura);

	}

	/**
	 * Busca todas as leituras
	 * 
	 * @return
	 */
	public List<Leitura> todosOsRegistros() {
		return entityManager.createQuery("select l from " + Leitura.class.getSimpleName() + " l").getResultList();
	}

	/**
	 * Busca a a leitura pelo id do livro
	 * 
	 * @param id
	 * @return
	 */
	public Leitura buscarPeloId(Long id) {
		String sql = "SELECT * FROM leitura where id_livro =" + id + ";";
		return (Leitura) entityManager.createNativeQuery(sql, Leitura.class).getSingleResult();
	}

	/**
	 * Busca todas as leituras relacionadas a a pessoa logada
	 * 
	 * @param id
	 * @return
	 */
	public List<Leitura> listaTodasLeiturasPessoaLogada(Long id) {
		String sql = "SELECT * FROM leitura where id_pessoa =" + id + ";";
		return entityManager.createNativeQuery(sql, Leitura.class).getResultList();
	}

}
