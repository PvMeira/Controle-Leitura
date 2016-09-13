package com.senac.cl.service;

import java.util.List;

import javax.inject.Inject;

import com.senac.cl.enums.tipoAcao;
import com.senac.cl.modelos.Pessoa;
import com.senac.cl.repository.PessoaRepository;
import com.senac.cl.transactional.Transactional;
/**
 * 
 * @author Pedro
 * @since 27/08/2016
 */
public class PessoaService {

	@Inject
	private PessoaRepository repositorio;
	@Inject
	private PessoaHistoricoService service;
	
/**
 * Metodo de Salvar - Aplica Regras de Negocio
 * @param pessoa
 */
	@Transactional
	public void salvar(Pessoa pessoa) {
		if (pessoa.getIdPessoa() == null) {
			repositorio.inserir(pessoa);
			service.atualizarHistorico(pessoa,tipoAcao.INCLUIR);
		} else {
			repositorio.atualizar(pessoa);
			service.atualizarHistorico(pessoa,tipoAcao.ALTERACAO);
		}
	}
/**
 * Metodo De listar
 * @return
 */
	@Transactional
	public List<Pessoa> carregarPessoasDoBancoDeDados() {
		return repositorio.todasAsPessoas();
	}
/**
 * Metodo de Deletar - Aplica Regras de Negocio
 * @param pessoa
 */
	@Transactional
	public void deletar(Pessoa pessoa) {
		repositorio.remover(pessoa);
		service.atualizarHistorico(pessoa,tipoAcao.DELETAR);
		
	}
	
	/**
	 * Metodo que retorna pessoa pelo seu ID
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public Pessoa buscaPessoaPeloId(Long id) {

		return repositorio.buscarPeloId(id);
	}
	
}
