package com.senac.cl.managed.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.senac.cl.modelos.Pessoa;
import com.senac.cl.service.PessoaService;
import com.senac.cl.utilitarios.SistemaDeMensagens;
/**
 * 
 * @author Pedro
 * @since 27/08/2016
 */
@ManagedBean
@ViewScoped
public class PessoaMB {

	private Pessoa pessoa;
	
	private List<Pessoa> listaDePessoasRegistradas;

	@Inject
	private PessoaService servico;

	public PessoaMB() {
	}
	/**
	 * Salva um novo usuario
	 * 
	 */
	
	public void salvar() {
		servico.salvar(getPessoa());
		SistemaDeMensagens.notificaINFORMACAO("Parabéns!", "Cadastro salvo com sucesso!");
		carregarListaDePessoas();
		limpar();
	}
	/**
	 * Deleta Um usuario do sistema 
	 * @param pessoa
	 */
	public void deletar(Pessoa pessoa) {
		servico.deletar(pessoa);
		SistemaDeMensagens.notificaINFORMACAO("Parabéns!", "Cadastro deletado com sucesso!");
		carregarListaDePessoas();
		limpar();
	}
	/**
	 * Metodo para limpar os campos após ação
	 */
	public void limpar() {
		setPessoa(new Pessoa());
	}
	/**
	 * metodo Set
	 */
	private void carregarListaDePessoas() {
		setListaDePessoasRegistradas(servico.carregarPessoasDoBancoDeDados());
	}
	/**
	 * 
	 * @return
	 */
	public List<Pessoa> getListaDePessoasRegistradas() {
		if (listaDePessoasRegistradas == null) {
			carregarListaDePessoas();
		}
		return listaDePessoasRegistradas;
	}
	/**
	 * 
	 * @param listaDePessoasRegistradas
	 */
	public void setListaDePessoasRegistradas(List<Pessoa> listaDePessoasRegistradas) {
		this.listaDePessoasRegistradas = listaDePessoasRegistradas;
	}
	/**
	 * 
	 * @return
	*/
	public Pessoa getPessoa() {
		if (pessoa == null) {
			limpar();
		}
		return pessoa;
	}
	/**
	 * 
	 * @param pessoa
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}