package com.senac.wir.managed.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.senac.wir.entidades.Login;
import com.senac.wir.servicos.LoginServico;
import com.senac.wir.util.Mensageiro;

@ManagedBean
@ViewScoped
public class LoginManagedBean {

	private Login login;
	private List<Login> listaDeLoginsCadastrados;

	@Inject
	private LoginServico servico;

	public LoginManagedBean() {
	}

	public void salvar() {
		servico.salvar(getLogin());
		Mensageiro.notificaInformacao("Parab�ns!", "Login salvo com sucesso!");
		carregaListaDeLogins();
		limpar();
	}

	public void deletar(Login login) {
		servico.deletar(login);
		Mensageiro.notificaInformacao("Parab�ns!", "Login deletado com sucesso!");
		carregaListaDeLogins();
		limpar();
	}

	public void limpar() {
		setLogin(new Login());
	}

	private void carregaListaDeLogins() {
		setListaDeLoginsCadastrados(servico.carregaTodosLoginsDoBanco());
	}

	public List<Login> getListaDeLoginsCadastrados() {
		if (listaDeLoginsCadastrados == null) {
			carregaListaDeLogins();
		}
		return listaDeLoginsCadastrados;
	}

	public void setListaDeLoginsCadastrados(List<Login> listaDeLoginsCadastrados) {
		this.listaDeLoginsCadastrados = listaDeLoginsCadastrados;
	}

	public Login getLogin() {
		if (login == null) {
			limpar();
		}
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

}