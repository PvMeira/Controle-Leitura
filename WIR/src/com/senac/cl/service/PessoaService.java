package com.senac.cl.service;

import java.util.List;

import javax.inject.Inject;

import com.senac.cl.modelos.Pessoa;
import com.senac.cl.repository.PessoaRepository;
import com.senac.cl.transactional.Transactional;

public class PessoaService {

	@Inject
	private PessoaRepository repositorio;

	@Transactional
	public void salvar(Pessoa pessoa) {
		if (pessoa.getId() == null) {
			repositorio.inserir(pessoa);
		} else {
			repositorio.atualizar(pessoa);
		}
	}

	@Transactional
	public List<Pessoa> carregarPessoasDoBancoDeDados() {
		return repositorio.todasAsPessoas();
	}

	@Transactional
	public void deletar(Pessoa pessoa) {
		repositorio.remover(pessoa);
		;
	}

}
