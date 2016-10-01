package com.senac.cl.modelos;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Pedro
 * @since 30/09/2016
 */
@Entity
@Table(name = "post")
@SequenceGenerator(name = "post_id_post_seq", sequenceName = "post_id_post_seq", allocationSize = 1, initialValue = 1)
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_id_post_seq")
	@Column(name = "id_post")
	private Long idPost;

	@NotNull
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "comentario_post", joinColumns = @JoinColumn(name = "id_comentario"), inverseJoinColumns = @JoinColumn(name = "id_post"))
	private List<Comentario> comentarios;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
	private Pessoa autor;

	@Column(name = "conteudo_post")
	@NotNull
	private String conteudo;

	@Column(name = "titulo_post")
	@NotNull
	private String titulo;

	@Column(name = "tag_post")
	@NotNull
	private String tag;
	
	@Column(name = "data_post")
	@NotNull
	private Calendar data;

	/**
	 * @param idPost
	 * @param comentarios
	 * @param autor
	 * @param conteudo
	 * @param titulo
	 * @param tag
	 */
	public Post(Long idPost, List<Comentario> comentarios, Pessoa autor, String conteudo, String titulo, String tag,Calendar data) {
		this.idPost = idPost;
		this.comentarios = comentarios;
		this.autor = autor;
		this.conteudo = conteudo;
		this.titulo = titulo;
		this.tag = tag;
		this.data = data;
	}

	/**
	 * 
	 */
	public Post() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the idPost
	 */
	public Long getIdPost() {
		return idPost;
	}

	/**
	 * @param idPost
	 *            the idPost to set
	 */
	public void setIdPost(Long idPost) {
		this.idPost = idPost;
	}

	/**
	 * @return the comentarios
	 */
	public List<Comentario> getComentarios() {
		return comentarios;
	}

	/**
	 * @param comentarios
	 *            the comentarios to set
	 */
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
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
