package com.senac.cl.service;

import java.util.Calendar;

import javax.inject.Inject;

import com.senac.cl.enums.tipoAcao;
import com.senac.cl.modelos.Pessoa;
import com.senac.cl.modelos.PessoaHistorico;
import com.senac.cl.repository.PessoaHistoricoRepository;

/**
 * 
 * @author Pedro
 *
 */
public class PessoaHistoricoService {

	@Inject
	private PessoaHistoricoRepository repository;
	/**
	 * Atualiza o historico setando os paramentos de acao e data
	 * @param pessoa
	 * @param tipo
	 */
	public void atualizarHistorico(Pessoa pessoa, tipoAcao tipo) {
		PessoaHistorico ph = new PessoaHistorico();
		//pessoa que realizou a a��o
		ph.setPessoa(pessoa);
		//sigla da a��o executada 
		ph.setTipoAcao(tipo.getSigla());
		//data da a��o executada 
		ph.setDataAcao(Calendar.getInstance());
		
		repository.AtualizarHistorico(ph);
	}

}
