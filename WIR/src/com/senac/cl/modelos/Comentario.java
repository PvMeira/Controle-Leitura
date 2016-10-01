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

import com.sun.istack.internal.NotNull;

/**
 * 
 * @author Pedro
 * @since 30/09/2016
 */
@Entity
@Table(name = "comentario")
@SequenceGenerator(name = "comentario_id_comentario_seq", sequenceName = "comentario_id_comentario_seq", allocationSize = 1, initialValue = 1)
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comentario_id_comentario_seq")
	@Column(name = "id_comentario")
	private Long idComentario;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
	private Pessoa autor;

	@Column(name = "conteudo")
	@NotNull
	private String conteudo;

	@Column(name = "titulo")
	@NotNull
	private String titulo;

	@Column(name = "tag")
	@NotNull
	private String tag;
	
	@Column(name = "data_comentario")
	@NotNull
	private Calendar data;

	/**
	 * 
	 */
	public Comentario() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idComentario
	 * @param autor
	 * @param conteudo
	 * @param titulo
	 * @param tag
	 */
	public Comentario(Long idComentario, Pessoa autor, String conteudo, String titulo, String tag, Calendar data) {
		this.idComentario = idComentario;
		this.autor = autor;
		this.conteudo = conteudo;
		this.titulo = titulo;
		this.tag = tag;
		this.data = data;
	}

	/**
	 * @return the idComentario
	 */
	public Long getIdComentario() {
		return idComentario;
	}

	/**
	 * @param idComentario
	 *            the idComentario to set
	 */
	public void setIdComentario(Long idComentario) {
		this.idComentario = idComentario;
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
	 * @return the tag
	 */
	public String getTag() {
		return tag;
	}

	/**
	 * @param tag
	 *            the tag to set
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 * @return the data
	 */
	public Calendar getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Calendar data) {
		this.data = data;
	}
	

}
