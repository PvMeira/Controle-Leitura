package com.senac.wir.managed.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.senac.wir.entidades.Pessoa;
import com.senac.wir.servicos.PessoaServico;
import com.senac.wir.util.Mensageiro;

@ManagedBean
@ViewScoped
public class PessoaManagedBean {

	private Pessoa pessoa;
	private List<Pessoa> listaDePessoasCadastradas;

	@Inject
	private PessoaServico servico;

	public PessoaManagedBean() {
	}

	public void salvar() {
		servico.salvar(getPessoa());
		Mensageiro.notificaInformacao("Parab�ns!", "Cadastro salvo com sucesso!");
		carregaListaDePessoas();
		limpar();
	}

	public void deletar(Pessoa pessoa) {
		servico.deletar(pessoa);
		Mensageiro.notificaInformacao("Parab�ns!", "Cadastro deletado com sucesso!");
		carregaListaDePessoas();
		limpar();
	}

	public void limpar() {
		setPessoa(new Pessoa());
	}

	private void carregaListaDePessoas() {
		setListaDePessoasCadastradas(servico.carregaTodasPessoasDoBanco());
	}

	public List<Pessoa> getListaDePessoasCadastradas() {
		if (listaDePessoasCadastradas == null) {
			carregaListaDePessoas();
		}
		return listaDePessoasCadastradas;
	}

	public void setListaDePessoasCadastradas(List<Pessoa> listaDePessoasCadastradas) {
		this.listaDePessoasCadastradas = listaDePessoasCadastradas;
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