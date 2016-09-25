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
 * @since 25/09/2016
 */
@Entity
@Table(name = "livro_historico")
@SequenceGenerator(name = "livro_historico_id_livro_historico_seq", sequenceName = "livro_historico_id_livro_historico_seq", allocationSize = 1, initialValue = 1)
public class LivroHistorico {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro_historico_id_livro_historico_seq")
	@Column(name = "id_livro_historico")
	private Long idLivroHistorico;
	
	@NotNull
	@Column(name = "nome_livro")
	private String nomeLivro;
	
	@Column(name = "observacao")
	private String observacao;
	
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


	/**
	 * @param idLivroHistorico
	 * @param nomeLivro
	 * @param observacao
	 * @param nomePessoa
	 * @param tipoAcao
	 * @param dataInicio
	 * @param datafim
	 * @param pessoaRealizouAcaoLogin
	 */
	public LivroHistorico(Long idLivroHistorico, String nomeLivro, String observacao, String nomePessoa,
			String tipoAcao, Calendar dataInicio, Calendar datafim, long pessoaRealizouAcaoLogin) {
		this.idLivroHistorico = idLivroHistorico;
		this.nomeLivro = nomeLivro;
		this.observacao = observacao;
		this.nomePessoa = nomePessoa;
		this.tipoAcao = tipoAcao;
		this.dataInicio = dataInicio;
		this.datafim = datafim;
		this.pessoaRealizouAcaoLogin = pessoaRealizouAcaoLogin;
	}


	/**
	 * 
	 */
	public LivroHistorico() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the idLivroHistorico
	 */
	public Long getIdLivroHistorico() {
		return idLivroHistorico;
	}


	/**
	 * @param idLivroHistorico the idLivroHistorico to set
	 */
	public void setIdLivroHistorico(Long idLivroHistorico) {
		this.idLivroHistorico = idLivroHistorico;
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
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}


	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
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
	
	
	
}
