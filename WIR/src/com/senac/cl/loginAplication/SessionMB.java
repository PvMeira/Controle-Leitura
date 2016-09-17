package com.senac.cl.loginAplication;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.senac.cl.modelos.Livro;
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
	
	private Pessoa usuarioSecao;
	private byte[] imagemUsuarioSecao;
	
	private static final String SEM_USUARIO = "Sem Usuario";

	@Inject
	private Pessoa pessoaED;

	@Inject
	PessoaRepository pessoaRP;
	
	
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
					this.getImagemUser();
					return "adm/pessoa-form.xhtml?faces-redirect=true";
				} else if (pessoaED.isNormal() == true) {
					ses.setAttribute("userNORMAL", pessoa);
					ses.setAttribute("user", pessoa);
					this.getImagemUser();
					return "normal/livro/livro-list-manager.xhtml?faces-redirect=true";
				}
			}
		}

		SistemaDeMensagens.notificaERRO("Usuario ou Senha inválidos", "");
		limpaCampos();
		return "";

	}
	  private void getImagemUser() {
		  	HttpSession ses = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
			Pessoa pesLogada= (Pessoa) ses.getAttribute("user");
			if(pesLogada.getFotoUser() != null){
	         this.imagemUsuarioSecao = pesLogada.getFotoUser();
			}else{
				this.imagemUsuarioSecao = this.converteFileToByteArray();
			}
	    }
	  
	  	private  byte[] converteFileToByteArray() {
			File f = new File("C:/devHome/workspace/WIR-WEBII-Project/WIR/WebContent/resources/imagens/iconeUser.png");
			FileInputStream fs = null;
			try {
				fs = new FileInputStream(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			byte[] byt = new byte[(int) f.length()];
			for (int i = 0; i < f.length(); i++) {
				try {
					byt[i] = (byte) fs.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				fs.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return byt;
		}
	
	/**
	 * Retorna o username da pessoa logada na seção
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
	 * meotodo que faz o logout da aplicação
	 * @return
	 */
	public String sair() {
		this.executaUpdateLogout();
		this.imagemUsuarioSecao = null;
		SessionUtil.getSession().invalidate();
		return "/paginas/Login.xhtml?faces-redirect=true";
	}
	/**
	 * Meotodo para executar o update do usuario logado
	 * ao sair da aplicação
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
	
	public Pessoa getUserLogado(){
	HttpSession ses = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	Pessoa pesLogada= (Pessoa) ses.getAttribute("user");
	if(pesLogada !=null){
		this.usuarioSecao = pesLogada;
		return this.usuarioSecao;
		}else{
			this.usuarioSecao	 =  new Pessoa();
			return this.usuarioSecao;
		}
			
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

	/**
	 * @return the usuarioSecao
	 */
	public Pessoa getUsuarioSecao() {
		return usuarioSecao;
	}

	/**
	 * @param usuarioSecao the usuarioSecao to set
	 */
	public void setUsuarioSecao(Pessoa usuarioSecao) {
		this.usuarioSecao = usuarioSecao;
	}
	/**
	 * @return the imagemUsuarioSecao
	 */
	public byte[] getImagemUsuarioSecao() {
		return imagemUsuarioSecao;
	}
	/**
	 * @param imagemUsuarioSecao the imagemUsuarioSecao to set
	 */
	public void setImagemUsuarioSecao(byte[] imagemUsuarioSecao) {
		this.imagemUsuarioSecao = imagemUsuarioSecao;
	}


}
