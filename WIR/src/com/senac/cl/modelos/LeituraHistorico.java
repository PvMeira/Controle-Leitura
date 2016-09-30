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
 * @since 18/09/2016
 */
@Entity
@Table(name = "leitura_historico")
@SequenceGenerator(name = "leitura_historico_id_leitura_historico_seq", sequenceName = "leitura_historico_id_leitura_historicoa_seq", allocationSize = 1, initialValue = 1)
public class LeituraHistorico {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leitura_historico_id_leitura_historico_seq")
	@Column(name = "id_leitura_historico")
	private Long idLeituraHistorico;
	
	@NotNull
	@Column(name = "nome_livro")
	private String nomeLivro;
	
	@Column(name = "observacao")
	private String observação;
	
	@NotNull
	@Column(name = "nome_pessoa")
	private String nomePessoa;
	@NotNull
	@Column(name = "tipo_acao")
	private String tipoAcao;
	
	@NotNull
	@Column(name = "data_inicio")
	private Calendar dataInicio;
	
	@Column(name = "data_fim")
	private Calendar datafim;
	
	
	@Column(name = "acao_login_pessoa")
	private long pessoaRealizouAcaoLogin;

	@Column(name = "id_dono")
	@NotNull
	private long idDono;
	
	
	
	
	/**
	 * 
	 */
	public LeituraHistorico() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param idLeituraHistorico
	 * @param nomeLivro
	 * @param observação
	 * @param nomePessoa
	 * @param dataInicio
	 * @param datafim
	 * @param pessoaRealizouAcaoLogin
	 */
	public LeituraHistorico(Long idLeituraHistorico, String nomeLivro, String observação, String nomePessoa,
			Calendar dataInicio, Calendar datafim, long pessoaRealizouAcaoLogin,String tipo, long idDono) {
		this.idLeituraHistorico = idLeituraHistorico;
		this.nomeLivro = nomeLivro;
		this.observação = observação;
		this.nomePessoa = nomePessoa;
		this.dataInicio = dataInicio;
		this.datafim = datafim;
		this.pessoaRealizouAcaoLogin = pessoaRealizouAcaoLogin;
		this.tipoAcao = tipo;
		this.idDono = idDono;
	}


	/**
	 * @return the idLeituraHistorico
	 */
	public Long getIdLeituraHistorico() {
		return idLeituraHistorico;
	}


	/**
	 * @param idLeituraHistorico the idLeituraHistorico to set
	 */
	public void setIdLeituraHistorico(Long idLeituraHistorico) {
		this.idLeituraHistorico = idLeituraHistorico;
	}


	/**
	 * @return the tipoAcao
	 */
	public String getTipoAcao() {
		return tipoAcao;
	}


	/**
	 * @param tipoAcao the tipoAcao to set
	 */
	public void setTipoAcao(String tipoAcao) {
		this.tipoAcao = tipoAcao;
	}


	/**
	 * @return the nomeLivro
	 */
	public String getNomeLivro() {
		return nomeLivro;
	}


	/**
	 * @param nomeLivro the nomeLivro to set
	 */
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}


	/**
	 * @return the observação
	 */
	public String getObservação() {
		return observação;
	}


	/**
	 * @param observação the observação to set
	 */
	public void setObservação(String observação) {
		this.observação = observação;
	}


	/**
	 * @return the nomePessoa
	 */
	public String getNomePessoa() {
		return nomePessoa;
	}


	/**
	 * @param nomePessoa the nomePessoa to set
	 */
	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}


	/**
	 * @return the dataInicio
	 */
	public Calendar getDataInicio() {
		return dataInicio;
	}


	/**
	 * @param dataInicio the dataInicio to set
	 */
	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}


	/**
	 * @return the datafim
	 */
	public Calendar getDatafim() {
		return datafim;
	}


	/**
	 * @param datafim the datafim to set
	 */
	public void setDatafim(Calendar datafim) {
		this.datafim = datafim;
	}


	/**
	 * @return the pessoaRealizouAcaoLogin
	 */
	public long getPessoaRealizouAcaoLogin() {
		return pessoaRealizouAcaoLogin;
	}


	/**
	 * @param pessoaRealizouAcaoLogin the pessoaRealizouAcaoLogin to set
	 */
	public void setPessoaRealizouAcaoLogin(long pessoaRealizouAcaoLogin) {
		this.pessoaRealizouAcaoLogin = pessoaRealizouAcaoLogin;
	}


	/**
	 * @return the idDono
	 */
	public long getIdDono() {
		return idDono;
	}


	/**
	 * @param idDono the idDono to set
	 */
	public void setIdDono(long idDono) {
		this.idDono = idDono;
	}
	
	

}
