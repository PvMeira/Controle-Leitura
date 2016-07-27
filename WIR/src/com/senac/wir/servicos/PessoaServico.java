package com.senac.wir.servicos;

import java.util.List;

import javax.inject.Inject;

import com.senac.wir.entidades.Pessoa;
import com.senac.wir.repositorios.PessoaRepositorio;
import com.senac.wir.transacao.Transacional;

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
