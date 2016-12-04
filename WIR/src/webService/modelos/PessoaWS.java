package webService.modelos;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.senac.cl.modelos.Livro;
import com.senac.cl.modelos.Pessoa;

/**
 * 
 * @author Pedro
 * @since 27/08/2016
 */
@XmlRootElement
public class PessoaWS {

	private Long idPessoa;

	private String nome;

	private String cpf;

	private String telefone;

	private String mail;

	private String username;

	private String password;

	private boolean adm;

	private boolean normal;

	private boolean logado = false;

	private Calendar dataUltimoLogin;

	private Calendar dataLoginAtual;

	/**
	 * 
	 */
	public PessoaWS() {

	}

	/**
	 * 
	 * @param id
	 * @param nome
	 * @param cpf
	 * @param telefone
	 * @param mail
	 * @param username
	 * @param password
	 * @param adm
	 * @param normal
	 * @param logado
	 * @param dataUltimoLogin
	 */
	public PessoaWS(Long id, String nome, String cpf, String telefone, String mail, String username, String password,
			boolean adm, boolean normal, boolean logado, Calendar dataUltimoLogin) {
		this.idPessoa = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.adm = adm;
		this.normal = normal;
		this.logado = logado;
		this.dataUltimoLogin = dataUltimoLogin;
	}

	/**
	 * 
	 * @return
	 */
	public Long getIdPessoa() {
		return idPessoa;
	}

	/**
	 * 
	 * @param idPessoa
	 */
	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}


	/**
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @return
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * 
	 * @param cpf
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * 
	 * @return
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * 
	 * @param telefone
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * 
	 * @return
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * 
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isAdm() {
		return adm;
	}

	/**
	 * 
	 * @param adm
	 */
	public void setAdm(boolean adm) {
		this.adm = adm;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isNormal() {
		return normal;
	}

	/**
	 * 
	 * @param normal
	 */
	public void setNormal(boolean normal) {
		this.normal = normal;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isLogado() {
		return logado;
	}

	/**
	 * 
	 * @param logado
	 */
	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	/**
	 * 
	 * @return
	 */
	public Calendar getDataUltimoLogin() {
		return dataUltimoLogin;
	}

	/**
	 * 
	 * @param dataUltimoLogin
	 */
	public void setDataUltimoLogin(Calendar dataUltimoLogin) {
		this.dataUltimoLogin = dataUltimoLogin;
	}

	/**
	 * 
	 * @return
	 */
	public Calendar getDataLoginAtual() {
		return dataLoginAtual;
	}

	/**
	 * 
	 * @param dataLoginAtual
	 */
	public void setDataLoginAtual(Calendar dataLoginAtual) {
		this.dataLoginAtual = dataLoginAtual;
	}

}
