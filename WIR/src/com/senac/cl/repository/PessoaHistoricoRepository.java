package com.senac.cl.repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.senac.cl.modelos.PessoaHistorico;

public class PessoaHistoricoRepository {

	@Inject
	private EntityManager entityManager;

	/**
	 * Faz o insert do historico no Banco
	 * 
	 * @param pessoa
	 */

	public void AtualizarHistorico(PessoaHistorico ph) {
		entityManager.persist(ph);

	}

}
