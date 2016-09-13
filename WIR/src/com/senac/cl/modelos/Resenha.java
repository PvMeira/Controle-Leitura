package com.senac.cl.modelos;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Pedro
 * @since 13/09/2016
 */

@Entity
@Table(name = "resenha")
@SequenceGenerator(name = "resenha_id_resenha_seq", sequenceName = "resenha_id_resenha_seq", allocationSize = 1, initialValue = 1)
public class Resenha {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resenha_id_resenha_seq")
	@Column(name = "id_resenha")
	private Long idResenha;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_livro", referencedColumnName = "id_livro")
	private Livro livroAlvo;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
	private Pessoa autor;

	@Column(name = "conteudo")

	private String conteudo;

	@Column(name = "assunto")

	private String assunto;

	@Column(name = "tipo")

	private String tipoResenha;

	@Column(name = "titulo")

	private String titulo;

	@Column(name = "publica")
	private boolean publica;

	@Column(name = "inacabada")
	private boolean inacabada;

	@Column(name = "data_inicio")
	@NotNull
	private Calendar dataInicio;

	@Column(name = "data_fim")
	private Calendar dataFim;

	public Resenha() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idResenha
	 * @param livroAlvo
	 * @param autor
	 * @param conteudo
	 * @param assunto
	 * @param tipoResenha
	 * @param publica
	 * @param dataInicio
	 * @param dataFim
	 */
	public Resenha(Long idResenha, Livro livroAlvo, Pessoa autor, String conteudo, String assunto, String tipoResenha,
			boolean publica, Calendar dataInicio, Calendar dataFim, String titulo, boolean inacabada) {
		this.idResenha = idResenha;
		this.livroAlvo = livroAlvo;
		this.autor = autor;
		this.conteudo = conteudo;
		this.assunto = assunto;
		this.tipoResenha = tipoResenha;
		this.publica = publica;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.titulo = titulo;
		this.inacabada = inacabada;
	}

	/**
	 * @return the idResenha
	 */
	public Long getIdResenha() {
		return idResenha;
	}

	/**
	 * @param idResenha
	 *            the idResenha to set
	 */
	public void setIdResenha(Long idResenha) {
		this.idResenha = idResenha;
	}

	/**
	 * @return the livroAlvo
	 */
	public Livro getLivroAlvo() {
		return livroAlvo;
	}

	/**
	 * @param livroAlvo
	 *            the livroAlvo to set
	 */
	public void setLivroAlvo(Livro livroAlvo) {
		this.livroAlvo = livroAlvo;
	}

	/**
	 * @return the autor
	 */
	public Pessoa getAutor() {
		return autor;
	}

	/**
	 * @param autor
	 *            the autor to set
	 */
	public void setAutor(Pessoa autor) {
		this.autor = autor;
	}

	/**
	 * @return the conteudo
	 */
	public String getConteudo() {
		return conteudo;
	}

	/**
	 * @param conteudo
	 *            the conteudo to set
	 */
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	/**
	 * @return the assunto
	 */
	public String getAssunto() {
		return assunto;
	}

	/**
	 * @param assunto
	 *            the assunto to set
	 */
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	/**
	 * @return the tipoResenha
	 */
	public String getTipoResenha() {
		return tipoResenha;
	}

	/**
	 * @param tipoResenha
	 *            the tipoResenha to set
	 */
	public void setTipoResenha(String tipoResenha) {
		this.tipoResenha = tipoResenha;
	}

	/**
	 * @return the publica
	 */
	public boolean isPublica() {
		return publica;
	}

	/**
	 * @param publica
	 *            the publica to set
	 */
	public void setPublica(boolean publica) {
		this.publica = publica;
	}

	/**
	 * @return the dataInicio
	 */
	public Calendar getDataInicio() {
		return dataInicio;
	}

	/**
	 * @param dataInicio
	 *            the dataInicio to set
	 */
	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	/**
	 * @return the dataFim
	 */
	public Calendar getDataFim() {
		return dataFim;
	}

	/**
	 * @param dataFim
	 *            the dataFim to set
	 */
	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the inacabada
	 */
	public boolean isInacabada() {
		return inacabada;
	}

	/**
	 * @param inacabada
	 *            the inacabada to set
	 */
	public void setInacabada(boolean inacabada) {
		this.inacabada = inacabada;
	}

}
