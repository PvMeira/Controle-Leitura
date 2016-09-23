package com.senac.cl.modelos;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @since 07/09
 */
@Entity
@Table(name = "livro")
@SequenceGenerator(name = "livro_id_livro_seq", sequenceName = "livro_id_livro_seq", allocationSize = 1, initialValue = 1)
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro_id_livro_seq")
	@Column(name = "id_livro")
	private Long idLivro;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
	private Pessoa dono;

	@Column(name = "titulo")
	@NotNull
	private String titulo;

	@Column(name = "autor")
	@NotNull
	private String autor;

	@Column(name = "paginas")
	@NotNull
	private int paginas;

	@Column(name = "observacao")
	@NotNull
	private String observacao;

	@Column(name = "pontuacao")
	@NotNull
	private int pontuacao;

	@Column(name = "livro_ativo")
	private boolean livroAtivo;

	@Column(name = "livro_ja_foi_lido")
	private boolean jaFoiLido;
	
	@Column(name = "publico")
	private boolean publico;

	@Column(name = "data_ultima_leitura")
	private Calendar dataUltimaLeitura;

	@Column(name = "data_upload")
	private Calendar dataUpload;

	@Column(name = "arquivo_livro")
	@NotNull
	private byte[] arquivo;

	/**
	 * 
	 */
	public Livro() {
	}

	/**
	 * @param idLivro
	 * @param dono
	 * @param titulo
	 * @param autor
	 * @param paginas
	 * @param observacao
	 * @param pontuacao
	 * @param livroAtivo
	 * @param dataUltimaLeitura
	 * @param dataUpload
	 */
	public Livro(Long idLivro, Pessoa dono, String titulo, String autor, int paginas, String observacao, int pontuacao,
			boolean livroAtivo, Calendar dataUltimaLeitura, Calendar dataUpload, boolean jaFoiLido,boolean publico) {
		this.idLivro = idLivro;
		this.dono = dono;
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
		this.observacao = observacao;
		this.pontuacao = pontuacao;
		this.livroAtivo = livroAtivo;
		this.dataUltimaLeitura = dataUltimaLeitura;
		this.dataUpload = dataUpload;
		this.jaFoiLido = jaFoiLido;
		this.publico = publico;
	}

	public Long getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	public Pessoa getDono() {
		return dono;
	}
	
	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}

	public void setDono(Pessoa dono) {
		this.dono = dono;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public boolean isLivroAtivo() {
		return livroAtivo;
	}

	public void setLivroAtivo(boolean livroAtivo) {
		this.livroAtivo = livroAtivo;
	}

	public Calendar getDataUltimaLeitura() {
		return dataUltimaLeitura;
	}

	public void setDataUltimaLeitura(Calendar dataUltimaLeitura) {
		this.dataUltimaLeitura = dataUltimaLeitura;
	}

	public Calendar getDataUpload() {
		return dataUpload;
	}

	public void setDataUpload(Calendar dataUpload) {
		this.dataUpload = dataUpload;
	}

	/**
	 * @return the arquivo
	 */
	public byte[] getArquivo() {
		return arquivo;
	}

	/**
	 * @param arquivo
	 *            the arquivo to set
	 */
	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	/**
	 * @return the jaFoiLido
	 */
	public boolean isJaFoiLido() {
		return jaFoiLido;
	}

	/**
	 * @param jaFoiLido
	 *            the jaFoiLido to set
	 */
	public void setJaFoiLido(boolean jaFoiLido) {
		this.jaFoiLido = jaFoiLido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((dataUltimaLeitura == null) ? 0 : dataUltimaLeitura.hashCode());
		result = prime * result + ((dataUpload == null) ? 0 : dataUpload.hashCode());
		result = prime * result + ((dono == null) ? 0 : dono.hashCode());
		result = prime * result + ((idLivro == null) ? 0 : idLivro.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + paginas;
		result = prime * result + pontuacao;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

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
		Livro other = (Livro) obj;
		if (autor == null) {
			if (other.autor != null) {
				return false;
			}
		} else if (!autor.equals(other.autor)) {
			return false;
		}
		if (dataUltimaLeitura == null) {
			if (other.dataUltimaLeitura != null) {
				return false;
			}
		} else if (!dataUltimaLeitura.equals(other.dataUltimaLeitura)) {
			return false;
		}
		if (dataUpload == null) {
			if (other.dataUpload != null) {
				return false;
			}
		} else if (!dataUpload.equals(other.dataUpload)) {
			return false;
		}
		if (dono == null) {
			if (other.dono != null) {
				return false;
			}
		} else if (!dono.equals(other.dono)) {
			return false;
		}
		if (idLivro == null) {
			if (other.idLivro != null) {
				return false;
			}
		} else if (!idLivro.equals(other.idLivro)) {
			return false;
		}
		if (livroAtivo != other.livroAtivo) {
			return false;
		}
		if (observacao == null) {
			if (other.observacao != null) {
				return false;
			}
		} else if (!observacao.equals(other.observacao)) {
			return false;
		}
		if (paginas != other.paginas) {
			return false;
		}
		if (pontuacao != other.pontuacao) {
			return false;
		}
		if (titulo == null) {
			if (other.titulo != null) {
				return false;
			}
		} else if (!titulo.equals(other.titulo)) {
			return false;
		}
		return true;
	}

}
