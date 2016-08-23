package com.senac.cl.managed.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.senac.cl.modelos.Pessoa;
import com.senac.cl.service.PessoaService;
import com.senac.cl.utilitarios.SistemaDeMensagens;

@ManagedBean
@ViewScoped
public class PessoaMB {

	private Pessoa pessoa;
	private List<Pessoa> listaDePessoasRegistradas;

	@Inject
	private PessoaService servico;

	public PessoaMB() {
	}

	public void salvar() {
		servico.salvar(getPessoa());
		SistemaDeMensagens.notificaINFORMACAO("Parabéns!", "Cadastro salvo com sucesso!");
		carregarListaDePessoas();
		limpar();
	}

	public void deletar(Pessoa pessoa) {
		servico.deletar(pessoa);
		SistemaDeMensagens.notificaINFORMACAO("Parabéns!", "Cadastro deletado com sucesso!");
		carregarListaDePessoas();
		limpar();
	}

	public void limpar() {
		setPessoa(new Pessoa());
	}

	private void carregarListaDePessoas() {
		setListaDePessoasRegistradas(servico.carregarPessoasDoBancoDeDados());
	}

	public List<Pessoa> getListaDePessoasRegistradas() {
		if (listaDePessoasRegistradas == null) {
			carregarListaDePessoas();
		}
		return listaDePessoasRegistradas;
	}

	public void setListaDePessoasRegistradas(List<Pessoa> listaDePessoasRegistradas) {
		this.listaDePessoasRegistradas = listaDePessoasRegistradas;
	}

	public Pessoa getPessoa() {
		if (pessoa == null) {
			limpar();
		}
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}