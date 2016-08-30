package com.senac.cl.modelos;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
/**
 * 
 * @author Pedro
 *
 */
@Entity
public class PessoaHistorico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PESSOA_HIST_NUM")
	private Long id_;

	@JoinColumn(name = "id_pessoa")
	@OneToOne(cascade = CascadeType.MERGE)
	@NotNull
	private Pessoa pessoa;

	@Column(name = "action_time")
	private Timestamp timestamp;

	@Column(name = "acao_tipo")
	private String tipo;

	public Long getId_() {
		return id_;
	}

	public void setId_(Long id_) {
		this.id_ = id_;
	}

	

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_ == null) ? 0 : id_.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaHistorico other = (PessoaHistorico) obj;
		if (id_ == null) {
			if (other.id_ != null)
				return false;
		} else if (!id_.equals(other.id_))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

}
