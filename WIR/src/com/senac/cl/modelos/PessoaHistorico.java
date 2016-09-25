package com.senac.cl.modelos;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Pedro
 * @since 07/09/2016
 */
@Entity
@Table(name = "pessoa_historico")
@SequenceGenerator(name = "pessoa_historico_id_pessoa_historico_seq", sequenceName = "pessoa_historico_id_pessoa_historico_seq", allocationSize = 1, initialValue = 1)
public class PessoaHistorico {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_historico_id_pessoa_historico_seq")
	@Column(name = "id_pessoa_historico")
	private Long idHistorico;

	@Column(name = "nome_login")
	@NotNull
	private String nomelogin;

	@Column(name = "nome_usuario")
	@NotNull
	private String nomeUsuario;

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
	 * @param nomelogin
	 * @param nomeUsuario
	 * @param dataAcao
	 * @param tipoAcao
	 */
	public PessoaHistorico(Long idHistorico, String nomelogin, String nomeUsuario, Calendar dataAcao, String tipoAcao) {
		this.idHistorico = idHistorico;
		this.nomelogin = nomelogin;
		this.nomeUsuario = nomeUsuario;
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
	 * @return the nomelogin
	 */
	public String getNomelogin() {
		return nomelogin;
	}

	/**
	 * @param nomelogin
	 *            the nomelogin to set
	 */
	public void setNomelogin(String nomelogin) {
		this.nomelogin = nomelogin;
	}

	/**
	 * @return the nomeUsuario
	 */
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	/**
	 * @param nomeUsuario
	 *            the nomeUsuario to set
	 */
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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

}
