package com.senac.wir.service;

import java.util.List;

import javax.inject.Inject;

import com.senac.wir.domain.Pessoa;
import com.senac.wir.repository.PessoaRepositorio;
import com.senac.wir.transactional.Transacional;

public class PessoaServico {

	@Inject
	private PessoaRepositorio repositorio;

	@Transacional
	public void salvar(Pessoa pessoa) {
		if (pessoa.getIdPessoa() == null) {
			repositorio.inserir(pessoa);
		} else {
			repositorio.atualizar(pessoa);
		}
	}

	@Transacional
	public List<Pessoa> carregaTodasPessoasDoBanco() {
		return repositorio.todasPessoas();
	}

	@Transacional
	public void deletar(Pessoa pessoa) {
		repositorio.remover(pessoa);
		;
	}

}
