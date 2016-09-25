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
 * @since 25/09/2016
 */
@Entity
@Table(name = "livro_publico")
@SequenceGenerator(name = "livro_publico_id_livro_publico_seq", sequenceName = "livro_publico_id_livro_publico_seq", allocationSize = 1, initialValue = 1)
public class LivroPublico {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "livro_publico_id_livro_publico_seq")
	@Column(name = "id_livro_publico")
	private Long idLivroPublico;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_pessoa_publico", referencedColumnName = "id_pessoa")
	private Pessoa donoPublico;

	@Column(name = "titulo_publico")
	@NotNull
	private String tituloPublico;

	@Column(name = "autor_publico")
	@NotNull
	private String autorPublico;

	@Column(name = "paginas_publico")
	@NotNull
	private int paginasPublico;

	@Column(name = "observacao_publico")
	@NotNull
	private String observacaoPublico;

	@Column(name = "pontuacao_publico")
	@NotNull
	private int pontuacaoPublico;


	@Column(name = "livro_ja_foi_lido_publico")
	private boolean jaFoiLidoPublico;

	@Column(name = "publico_publico")
	private boolean publicoPublico;

	@Column(name = "data_ultima_leitura_publico")
	private Calendar dataUltimaLeituraPublico;

	@Column(name = "data_upload_publico")
	private Calendar dataUploadPublico;

	@Column(name = "arquivo_livro_publico")
	@NotNull
	private byte[] arquivoPublico;

	/**
	 * 
	 */
	public LivroPublico() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idLivroPublico
	 * @param donoPublico
	 * @param tituloPublico
	 * @param autorPublico
	 * @param paginasPublico
	 * @param observacaoPublico
	 * @param pontuacaoPublico
	 * @param jaFoiLidoPublico
	 * @param publicoPublico
	 * @param dataUltimaLeituraPublico
	 * @param dataUploadPublico
	 * @param arquivoPublico
	 */
	public LivroPublico(Long idLivroPublico, Pessoa donoPublico, String tituloPublico, String autorPublico,
			int paginasPublico, String observacaoPublico, int pontuacaoPublico, boolean jaFoiLidoPublico,
			boolean publicoPublico, Calendar dataUltimaLeituraPublico, Calendar dataUploadPublico,
		    byte[] arquivoPublico) {
		
		this.idLivroPublico = idLivroPublico;
		this.donoPublico = donoPublico;
		this.tituloPublico = tituloPublico;
		this.autorPublico = autorPublico;
		this.paginasPublico = paginasPublico;
		this.observacaoPublico = observacaoPublico;
		this.pontuacaoPublico = pontuacaoPublico;
		this.jaFoiLidoPublico = jaFoiLidoPublico;
		this.publicoPublico = publicoPublico;
		this.dataUltimaLeituraPublico = dataUltimaLeituraPublico;
		this.dataUploadPublico = dataUploadPublico;
		this.arquivoPublico = arquivoPublico;
	}

	/**
	 * @return the idLivroPublico
	 */
	public Long getIdLivroPublico() {
		return idLivroPublico;
	}

	/**
	 * @param idLivroPublico the idLivroPublico to set
	 */
	public void setIdLivroPublico(Long idLivroPublico) {
		this.idLivroPublico = idLivroPublico;
	}

	/**
	 * @return the donoPublico
	 */
	public Pessoa getDonoPublico() {
		return donoPublico;
	}

	/**
	 * @param donoPublico the donoPublico to set
	 */
	public void setDonoPublico(Pessoa donoPublico) {
		this.donoPublico = donoPublico;
	}

	/**
	 * @return the tituloPublico
	 */
	public String getTituloPublico() {
		return tituloPublico;
	}

	/**
	 * @param tituloPublico the tituloPublico to set
	 */
	public void setTituloPublico(String tituloPublico) {
		this.tituloPublico = tituloPublico;
	}

	/**
	 * @return the autorPublico
	 */
	public String getAutorPublico() {
		return autorPublico;
	}

	/**
	 * @param autorPublico the autorPublico to set
	 */
	public void setAutorPublico(String autorPublico) {
		this.autorPublico = autorPublico;
	}

	/**
	 * @return the paginasPublico
	 */
	public int getPaginasPublico() {
		return paginasPublico;
	}

	/**
	 * @param paginasPublico the paginasPublico to set
	 */
	public void setPaginasPublico(int paginasPublico) {
		this.paginasPublico = paginasPublico;
	}

	/**
	 * @return the observacaoPublico
	 */
	public String getObservacaoPublico() {
		return observacaoPublico;
	}

	/**
	 * @param observacaoPublico the observacaoPublico to set
	 */
	public void setObservacaoPublico(String observacaoPublico) {
		this.observacaoPublico = observacaoPublico;
	}

	/**
	 * @return the pontuacaoPublico
	 */
	public int getPontuacaoPublico() {
		return pontuacaoPublico;
	}

	/**
	 * @param pontuacaoPublico the pontuacaoPublico to set
	 */
	public void setPontuacaoPublico(int pontuacaoPublico) {
		this.pontuacaoPublico = pontuacaoPublico;
	}

	/**
	 * @return the jaFoiLidoPublico
	 */
	public boolean isJaFoiLidoPublico() {
		return jaFoiLidoPublico;
	}

	/**
	 * @param jaFoiLidoPublico the jaFoiLidoPublico to set
	 */
	public void setJaFoiLidoPublico(boolean jaFoiLidoPublico) {
		this.jaFoiLidoPublico = jaFoiLidoPublico;
	}

	/**
	 * @return the publicoPublico
	 */
	public boolean isPublicoPublico() {
		return publicoPublico;
	}

	/**
	 * @param publicoPublico the publicoPublico to set
	 */
	public void setPublicoPublico(boolean publicoPublico) {
		this.publicoPublico = publicoPublico;
	}

	/**
	 * @return the dataUltimaLeituraPublico
	 */
	public Calendar getDataUltimaLeituraPublico() {
		return dataUltimaLeituraPublico;
	}

	/**
	 * @param dataUltimaLeituraPublico the dataUltimaLeituraPublico to set
	 */
	public void setDataUltimaLeituraPublico(Calendar dataUltimaLeituraPublico) {
		this.dataUltimaLeituraPublico = dataUltimaLeituraPublico;
	}

	/**
	 * @return the dataUploadPublico
	 */
	public Calendar getDataUploadPublico() {
		return dataUploadPublico;
	}

	/**
	 * @param dataUploadPublico the dataUploadPublico to set
	 */
	public void setDataUploadPublico(Calendar dataUploadPublico) {
		this.dataUploadPublico = dataUploadPublico;
	}

	/**
	 * @return the arquivoPublico
	 */
	public byte[] getArquivoPublico() {
		return arquivoPublico;
	}

	/**
	 * @param arquivoPublico the arquivoPublico to set
	 */
	public void setArquivoPublico(byte[] arquivoPublico) {
		this.arquivoPublico = arquivoPublico;
	}
	
	
}
