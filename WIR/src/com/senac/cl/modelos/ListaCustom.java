package com.senac.cl.modelos;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "lista_cust")
@SequenceGenerator(name = "lista_custumizada_id_lista_cust_seq", sequenceName = "lista_custumizada_id_lista_cust_seq", allocationSize = 1, initialValue = 1)
public class ListaCustom {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lista_custumizada_id_lista_cust_seq")
	@Column(name = "id_lista_customizada")
	private Long idListaCustomizada;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
	private Pessoa pessoa;

	@NotNull
	@ManyToMany
	@JoinColumn(name = "id_livro", referencedColumnName = "id_livro")
	private List<Livro> livro;

	@NotNull
	@Column(name = "nome_lista")
	private String nomeLista;

	@NotNull
	@Column(name = "tipo_lista")
	private String tipoLista;

	@Column(name = "descricao")
	private String descricao;

	@NotNull
	@Column(name = "data_inclusao")
	private Calendar dataInclusao;

	@NotNull
	@Column(name = "publico")
	private boolean publico;

	/**
	 * @return the idListaCustomizada
	 */
	public Long getIdListaCustomizada() {
		return idListaCustomizada;
	}

	/**
	 * @param idListaCustomizada
	 *            the idListaCustomizada to set
	 */
	public void setIdListaCustomizada(Long idListaCustomizada) {
		this.idListaCustomizada = idListaCustomizada;
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
	 * @return the livro
	 */
	public List<Livro> getLivro() {
		return livro;
	}

	/**
	 * @param livro
	 *            the livro to set
	 */
	public void setLivro(List<Livro> livro) {
		this.livro = livro;
	}

	/**
	 * @return the nomeLista
	 */
	public String getNomeLista() {
		return nomeLista;
	}

	/**
	 * @param nomeLista
	 *            the nomeLista to set
	 */
	public void setNomeLista(String nomeLista) {
		this.nomeLista = nomeLista;
	}

	/**
	 * @return the tipoLista
	 */
	public String getTipoLista() {
		return tipoLista;
	}

	/**
	 * @param tipoLista
	 *            the tipoLista to set
	 */
	public void setTipoLista(String tipoLista) {
		this.tipoLista = tipoLista;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao
	 *            the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the dataInclusao
	 */
	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	/**
	 * @param dataInclusao
	 *            the dataInclusao to set
	 */
	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	/**
	 * @return the publico
	 */
	public boolean isPublico() {
		return publico;
	}

	/**
	 * @param publico
	 *            the publico to set
	 */
	public void setPublico(boolean publico) {
		this.publico = publico;
	}

	/**
	 * 
	 */
	public ListaCustom() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idListaCustomizada
	 * @param pessoa
	 * @param livro
	 * @param nomeLista
	 * @param tipoLista
	 * @param descricao
	 * @param dataInclusao
	 * @param publico
	 */
	public ListaCustom(Long idListaCustomizada, Pessoa pessoa, List<Livro> livro, String nomeLista, String tipoLista,
			String descricao, Calendar dataInclusao, boolean publico) {
		this.idListaCustomizada = idListaCustomizada;
		this.pessoa = pessoa;
		this.livro = livro;
		this.nomeLista = nomeLista;
		this.tipoLista = tipoLista;
		this.descricao = descricao;
		this.dataInclusao = dataInclusao;
		this.publico = publico;
	}

}
