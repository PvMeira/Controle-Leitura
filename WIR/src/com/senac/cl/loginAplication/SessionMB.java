package com.senac.cl.loginAplication;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.senac.cl.modelos.Pessoa;
import com.senac.cl.repository.PessoaRepository;
import com.senac.cl.utilitarios.SistemaDeMensagens;

/**
 * 
 * @author Pedro
 *
 */
@ApplicationScoped
@ManagedBean(eager = true)
public class SessionMB implements Serializable {

	private static final long serialVersionUID = 8029574545986350859L;

	private String usernameLogin;

	private String passwordLogin;

	@Inject
	private Pessoa pessoaED;

	@Inject
	PessoaRepository pessoaRP;

	/**
	 * Meotodo que realiza a entrada na aplicação e faz o redirect conforme a permisao
	 * 
	 * @return
	 */
	public String entrar() {
		List<Pessoa> listaDePessoas = pessoaRP.todasAsPessoas();

		for (Pessoa pessoa : listaDePessoas) {
			if (pessoa.getUsername().equals(this.usernameLogin) && pessoa.getPassword().equals(this.passwordLogin)) {
				this.pessoaED = pessoa;
				this.pessoaED.setDataLoginAtual(Calendar.getInstance());
				this.pessoaED.setLogado(true);
				if (pessoaED.isAdm() == true) {

					return "adm/pessoa-form.xhtml?faces-redirect=true";
				} else if (pessoaED.isNormal() == true) {
					return "normal/livro-list.xhtml?faces-redirect=true";
				}
			}
		}

		SistemaDeMensagens.notificaERRO("Usuario ou Senha inválidos", "");
		limpaCampos();
		return "";

	}
	/**
	 * meotodo que faz o logout da aplicação
	 * @return
	 */
	public String sair() {
		this.executaUpdateLogout();
		SessionUtil.getSession().invalidate();
		return "Login.xhtml?faces-redirect=true";
	}
	/**
	 * Meotodo para executar o update do usuario logado
	 * ao sair da aplicação
	 */
	public void executaUpdateLogout(){
		Pessoa p =new Pessoa();
		p = this.pessoaED;
		p.setLogado(false);
		p.setDataUltimoLogin(this.pessoaED.getDataLoginAtual());
		pessoaRP.atualizar(p);
	}
	
	/**
	 * limpa os campos user e senha 
	 */
	public void limpaCampos() {
		this.passwordLogin = null;
		this.usernameLogin = null;
	}

	
	//get & set
	
	/**
	 * 
	 * @return
	 */
	public String getUsernameLogin() {
		return usernameLogin;
	}
	/**
	 * 
	 * @param usernameLogin
	 */
	public void setUsernameLogin(String usernameLogin) {
		this.usernameLogin = usernameLogin;
	}
	/**
	 * 
	 * @return
	 */
	public String getPasswordLogin() {
		return passwordLogin;
	}
	/**
	 * 
	 * @param passwordLogin
	 */
	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}
	/**
	 * 
	 * @return
	 */
	public Pessoa getPessoaED() {
		return pessoaED;
	}
	/**
	 * 
	 * @param pessoaED
	 */
	public void setPessoaED(Pessoa pessoaED) {
		this.pessoaED = pessoaED;
	}

}
