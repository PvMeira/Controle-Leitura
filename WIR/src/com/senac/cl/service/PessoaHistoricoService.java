package com.senac.cl.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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

	public void atualizarHistorico(Pessoa pessoa,tipoAcao tipo) {
		PessoaHistorico ph = new PessoaHistorico();
			ph.setPessoa(pessoa);
			ph.setTipo(tipo.getSigla());
			ph.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
			
		repository.AtualizarHistorico(ph);
	}
	
	
	
}
