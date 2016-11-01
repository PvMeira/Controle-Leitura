package com.senac.cl.modelos;

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

/**
 * 
 * @author Pedro
 * @since 27/08/2016
 */
@Entity
@Table(name = "pessoa")
@SequenceGenerator(name = "pessoa_id_pessoa_seq", sequenceName = "pessoa_id_pessoa_seq", allocationSize = 1)
@NamedQuery(name="Pessoa.findAll", query="SELECT c FROM Pessoa c") 
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_id_pessoa_seq")
	@Column(name = "id_pessoa")
	private Long idPessoa;

	@OneToMany(mappedBy = "dono", cascade = CascadeType.ALL)
	private List<Livro> livros;

	@Column(name = "nome")
	@NotNull
	private String nome;

	@Column(name = "cpf")
	@NotNull
	private String cpf;

	@Column(name = "telefone")
	@NotNull
	private String telefone;

	@Column(name = "mail")
	@NotNull
	private String mail;

	@Column(name = "login")
	@NotNull
	private String username;

	@Column(name = "senha")
	@NotNull
	private String password;

	@Column(name = "adm_user")
	private boolean adm;

	@Column(name = "normal_user")
	private boolean normal;

	@Column(name = "logado_user")
	private boolean logado = false;

	@Column(name = "data_ultimo_login")
	private Calendar dataUltimoLogin;

	@Column(name = "foto_user")
	private byte[] fotoUser;

	@Transient
	private Calendar dataLoginAtual;

	/**
	 * 
	 */
	public Pessoa() {

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
	public Pessoa(Long id, String nome, String cpf, String telefone, String mail, String username, String password,
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
	public List<Livro> getLivros() {
		return livros;
	}

	/**
	 * @return the fotoUser
	 */
	public byte[] getFotoUser() {
		return fotoUser;
	}

	/**
	 * @param fotoUser
	 *            the fotoUser to set
	 */
	public void setFotoUser(byte[] fotoUser) {
		this.fotoUser = fotoUser;
	}

	/**
	 * 
	 * @param livros
	 */
	public void setLivros(List<Livro> livros) {
		this.livros = livros;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (adm ? 1231 : 1237);
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataLoginAtual == null) ? 0 : dataLoginAtual.hashCode());
		result = prime * result + ((dataUltimoLogin == null) ? 0 : dataUltimoLogin.hashCode());
		result = prime * result + ((idPessoa == null) ? 0 : idPessoa.hashCode());
		result = prime * result + ((livros == null) ? 0 : livros.hashCode());
		result = prime * result + (logado ? 1231 : 1237);
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (normal ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Pessoa other = (Pessoa) obj;
		if (adm != other.adm) {
			return false;
		}
		if (cpf == null) {
			if (other.cpf != null) {
				return false;
			}
		} else if (!cpf.equals(other.cpf)) {
			return false;
		}
		if (dataLoginAtual == null) {
			if (other.dataLoginAtual != null) {
				return false;
			}
		} else if (!dataLoginAtual.equals(other.dataLoginAtual)) {
			return false;
		}
		if (dataUltimoLogin == null) {
			if (other.dataUltimoLogin != null) {
				return false;
			}
		} else if (!dataUltimoLogin.equals(other.dataUltimoLogin)) {
			return false;
		}
		if (idPessoa == null) {
			if (other.idPessoa != null) {
				return false;
			}
		} else if (!idPessoa.equals(other.idPessoa)) {
			return false;
		}
		if (livros == null) {
			if (other.livros != null) {
				return false;
			}
		} else if (!livros.equals(other.livros)) {
			return false;
		}
		if (logado != other.logado) {
			return false;
		}
		if (mail == null) {
			if (other.mail != null) {
				return false;
			}
		} else if (!mail.equals(other.mail)) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		if (normal != other.normal) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (telefone == null) {
			if (other.telefone != null) {
				return false;
			}
		} else if (!telefone.equals(other.telefone)) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}

}