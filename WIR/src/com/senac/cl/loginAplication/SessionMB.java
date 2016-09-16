package com.senac.cl.loginAplication;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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
	
	private Pessoa pessoaLogado;
	
	private static final String SEM_USUARIO = "Sem Usuario";

	@Inject
	private Pessoa pessoaED;

	@Inject
	PessoaRepository pessoaRP;
	

	/**
	 * Meotodo que realiza a entrada na aplica��o e faz o redirect conforme a permisao
	 * 
	 * @return
	 */
	public String entrar() {
		List<Pessoa> listaDePessoas = pessoaRP.todasAsPessoas();

		for (Pessoa pessoa : listaDePessoas) {
			if (pessoa.getUsername().equals(this.usernameLogin) && pessoa.getPassword().equals(this.passwordLogin)) {
				this.setPessoaED(pessoa);
				HttpSession ses = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
				this.pessoaED.setDataLoginAtual(Calendar.getInstance());
				this.pessoaED.setLogado(true);
				if (pessoaED.isAdm() == true) {
					
					ses.setAttribute("userADM", pessoa);
					ses.setAttribute("user", pessoa);
					return "adm/pessoa-form.xhtml?faces-redirect=true";
				} else if (pessoaED.isNormal() == true) {
					
					ses.setAttribute("userNORMAL", pessoa);
					ses.setAttribute("user", pessoa);
					return "normal/livro/livro-list-manager.xhtml?faces-redirect=true";
				}
			}
		}

		SistemaDeMensagens.notificaERRO("Usuario ou Senha inv�lidos", "");
		limpaCampos();
		return "";

	}
	
	/**
	 * Retorna o username da pessoa logada na se��o
	 * @return
	 */
	public String getNomeUsuarioLogado(){
		HttpSession ses = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Pessoa pesLogada= (Pessoa) ses.getAttribute("user");
		if(pesLogada != null){
		return pesLogada.getUsername();
		}else{
			return SEM_USUARIO ;
		}
		
	}
	
	/**
	 * meotodo que faz o logout da aplica��o
	 * @return
	 */
	public String sair() {
		this.executaUpdateLogout();
		SessionUtil.getSession().invalidate();
		return "Login.xhtml?faces-redirect=true";
	}
	/**
	 * Meotodo para executar o update do usuario logado
	 * ao sair da aplica��o
	 */
	public void executaUpdateLogout(){
		Pessoa p =new Pessoa();
		HttpSession ses = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		ses.removeAttribute("userADM");
		ses.removeAttribute("userNORMAL");
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
	/**
	 * @return the pessoaLogado
	 */
	public Pessoa getPessoaLogado() {
		return pessoaLogado;
	}
	/**
	 * @param pessoaLogado the pessoaLogado to set
	 */
	public void setPessoaLogado(Pessoa pessoaLogado) {
		this.pessoaLogado = pessoaLogado;
	}
	

}
