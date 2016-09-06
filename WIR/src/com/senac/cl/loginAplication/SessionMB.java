package com.senac.cl.loginAplication;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.senac.cl.modelos.Pessoa;
import com.senac.cl.repository.PessoaRepository;
import com.senac.cl.utilitarios.SistemaDeMensagens;
/**
 * 
 * @author Pedro
 *
 */
@ViewScoped
@ManagedBean(eager = true)
public class SessionMB implements Serializable {

	private static final long serialVersionUID = 8029574545986350859L;

	private String usernameLogin;

	private String passwordLogin;
	
	@Inject
	private Pessoa pessoaED;

	@Inject
	PessoaRepository pessoaRP;

	public String entrar() {
		List<Pessoa> listaDePessoas = pessoaRP.todasAsPessoas();

		for (Pessoa pessoa : listaDePessoas) {
			if (pessoa.getUsername().equals(this.usernameLogin) && pessoa.getPassword().equals(this.passwordLogin)) {
				this.pessoaED = pessoa;
				pessoaED.setLogado(true);
				if (pessoaED.isAdm() == true) {
					
					return "adm/pessoa-form.xhtml?faces-redirect=true";
				} else if (pessoaED.isNormal() == true) {
					return "normal/Teste.xhtml?faces-redirect=true";
				}
			}
		}

		SistemaDeMensagens.notificaERRO("Usuario ou Senha inválidos", "");
		limpaCampos();
		return "";

	}

	public String sair() {
		SessionUtil.getSession().invalidate();
		return "Login.xhtml?faces-redirect=true";
	}
	public void limpaCampos(){
		this.passwordLogin = null;
		this.usernameLogin = null;
	}

	public String getUsernameLogin() {
		return usernameLogin;
	}

	public void setUsernameLogin(String usernameLogin) {
		this.usernameLogin = usernameLogin;
	}

	public String getPasswordLogin() {
		return passwordLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}

	public Pessoa getPessoaED() {
		return pessoaED;
	}

	public void setPessoaED(Pessoa pessoaED) {
		this.pessoaED = pessoaED;
	}

}
