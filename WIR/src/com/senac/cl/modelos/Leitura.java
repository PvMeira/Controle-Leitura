package com.senac.cl.modelos;

import java.util.Calendar;

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
 * @since 11/09/2016
 */
@Entity
@Table(name = "leitura")
@SequenceGenerator(name = "leitura_id_leitura_seq", sequenceName = "leitura_id_leitura_seq", allocationSize = 1, initialValue = 1)
public class Leitura {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leitura_id_leitura_seq")
	@Column(name = "id_leitura")
	private Long idLeitura;

	@OneToOne
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
	@NotNull
	private Pessoa leitor;

	@OneToOne
	@JoinColumn(name = "id_livro", referencedColumnName = "id_livro")
	@NotNull
	private Livro livro;

	@Column(name = "data_inicio")
	@NotNull
	private Calendar dataInicio;

	@Column(name = "observacao")
	@NotNull
	private String observacao;

	@Column(name = "pagina_atual")
	@NotNull
	private int paginaAtual;

	@Column(name = "pagina_total")
	@NotNull
	private int paginaTotal;

	/**
	 * 
	 */
	public Leitura() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idLeitura
	 * @param leitor
	 * @param livro
	 * @param dataInicio
	 * @param observacao
	 * @param paginaAtual
	 * @param paginaTotal
	 */
	public Leitura(Long idLeitura, Pessoa leitor, Livro livro, Calendar dataInicio, String observacao, int paginaAtual,
			int paginaTotal) {
		this.idLeitura = idLeitura;
		this.leitor = leitor;
		this.livro = livro;
		this.dataInicio = dataInicio;
		this.observacao = observacao;
		this.paginaAtual = paginaAtual;
		this.paginaTotal = paginaTotal;
	}

	/**
	 * @return the idLeitura
	 */
	public Long getIdLeitura() {
		return idLeitura;
	}

	/**
	 * @param idLeitura
	 *            the idLeitura to set
	 */
	public void setIdLeitura(Long idLeitura) {
		this.idLeitura = idLeitura;
	}

	/**
	 * @return the leitor
	 */
	public Pessoa getLeitor() {
		return leitor;
	}

	/**
	 * @param leitor
	 *            the leitor to set
	 */
	public void setLeitor(Pessoa leitor) {
		this.leitor = leitor;
	}

	/**
	 * @return the livro
	 */
	public Livro getLivro() {
		return livro;
	}

	/**
	 * @param livro
	 *            the livro to set
	 */
	public void setLivro(Livro livro) {
		this.livro = livro;
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
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}

	/**
	 * @param observacao
	 *            the observacao to set
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	/**
	 * @return the paginaAtual
	 */
	public int getPaginaAtual() {
		return paginaAtual;
	}

	/**
	 * @param paginaAtual
	 *            the paginaAtual to set
	 */
	public void setPaginaAtual(int paginaAtual) {
		this.paginaAtual = paginaAtual;
	}

	/**
	 * @return the paginaTotal
	 */
	public int getPaginaTotal() {
		return paginaTotal;
	}

	/**
	 * @param paginaTotal
	 *            the paginaTotal to set
	 */
	public void setPaginaTotal(int paginaTotal) {
		this.paginaTotal = paginaTotal;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((idLeitura == null) ? 0 : idLeitura.hashCode());
		result = prime * result + ((leitor == null) ? 0 : leitor.hashCode());
		result = prime * result + ((livro == null) ? 0 : livro.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + paginaAtual;
		result = prime * result + paginaTotal;
		return result;
	}

	/* (non-Javadoc)
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
		Leitura other = (Leitura) obj;
		if (dataInicio == null) {
			if (other.dataInicio != null) {
				return false;
			}
		} else if (!dataInicio.equals(other.dataInicio)) {
			return false;
		}
		if (idLeitura == null) {
			if (other.idLeitura != null) {
				return false;
			}
		} else if (!idLeitura.equals(other.idLeitura)) {
			return false;
		}
		if (leitor == null) {
			if (other.leitor != null) {
				return false;
			}
		} else if (!leitor.equals(other.leitor)) {
			return false;
		}
		if (livro == null) {
			if (other.livro != null) {
				return false;
			}
		} else if (!livro.equals(other.livro)) {
			return false;
		}
		if (observacao == null) {
			if (other.observacao != null) {
				return false;
			}
		} else if (!observacao.equals(other.observacao)) {
			return false;
		}
		if (paginaAtual != other.paginaAtual) {
			return false;
		}
		if (paginaTotal != other.paginaTotal) {
			return false;
		}
		return true;
	}

}
