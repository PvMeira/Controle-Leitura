package com.senac.cl.modelos;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Pedro
 * @since  07/09/2016
 */
@Entity
@Table(name = "pessoa_historico")
@SequenceGenerator(name = "pessoa_historico_id_pessoa_historico_seq", sequenceName = "pessoa_historico_id_pessoa_historico_seq", allocationSize = 1, initialValue = 1)
public class PessoaHistorico {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_historico_id_pessoa_historico_seq")
	@Column(name = "id_pessoa_historico")
	private Long idHistorico;

	@JoinColumn(name = "id_pessoa")
	@OneToOne(cascade = CascadeType.MERGE, orphanRemoval = true)
	@NotNull
	private Pessoa pessoa;

	@Column(name = "data_acao_usuario")
	@NotNull
	private Calendar dataAcao;

	@Column(name = "tipo_acao")
	@NotNull
	private String tipoAcao;

	/**
	 * 
	 */
	public PessoaHistorico() {
	}

	/**
	 * @param idHistorico
	 * @param pessoa
	 * @param dataAcao
	 * @param tipoAcao
	 */
	public PessoaHistorico(Long idHistorico, Pessoa pessoa, Calendar dataAcao, String tipoAcao) {
		this.idHistorico = idHistorico;
		this.pessoa = pessoa;
		this.dataAcao = dataAcao;
		this.tipoAcao = tipoAcao;
	}

	/**
	 * @return the idHistorico
	 */
	public Long getIdHistorico() {
		return idHistorico;
	}

	/**
	 * @param idHistorico
	 *            the idHistorico to set
	 */
	public void setIdHistorico(Long idHistorico) {
		this.idHistorico = idHistorico;
	}

	/**
	 * @return the pessoa
	 */
	public Pessoa getPessoa() {
		return pessoa;
	}

	/**
	 * @param pessoa
	 *            the pessoa to set
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	/**
	 * @return the dataAcao
	 */
	public Calendar getDataAcao() {
		return dataAcao;
	}

	/**
	 * @param dataAcao
	 *            the dataAcao to set
	 */
	public void setDataAcao(Calendar dataAcao) {
		this.dataAcao = dataAcao;
	}

	/**
	 * @return the tipoAcao
	 */
	public String getTipoAcao() {
		return tipoAcao;
	}

	/**
	 * @param tipoAcao
	 *            the tipoAcao to set
	 */
	public void setTipoAcao(String tipoAcao) {
		this.tipoAcao = tipoAcao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAcao == null) ? 0 : dataAcao.hashCode());
		result = prime * result + ((idHistorico == null) ? 0 : idHistorico.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((tipoAcao == null) ? 0 : tipoAcao.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
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
		PessoaHistorico other = (PessoaHistorico) obj;
		if (dataAcao == null) {
			if (other.dataAcao != null) {
				return false;
			}
		} else if (!dataAcao.equals(other.dataAcao)) {
			return false;
		}
		if (idHistorico == null) {
			if (other.idHistorico != null) {
				return false;
			}
		} else if (!idHistorico.equals(other.idHistorico)) {
			return false;
		}
		if (pessoa == null) {
			if (other.pessoa != null) {
				return false;
			}
		} else if (!pessoa.equals(other.pessoa)) {
			return false;
		}
		if (tipoAcao == null) {
			if (other.tipoAcao != null) {
				return false;
			}
		} else if (!tipoAcao.equals(other.tipoAcao)) {
			return false;
		}
		return true;
	}

}
