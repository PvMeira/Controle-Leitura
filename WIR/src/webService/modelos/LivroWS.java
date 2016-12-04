package webService.modelos;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LivroWS {

	private Long idLivro;

	private String titulo;

	private String autor;

	private int paginas;

	private String observacao;

	private int pontuacao;

	private boolean livroAtivo;

	private boolean jaFoiLido;

	private boolean publico;

	private Calendar dataUltimaLeitura;

	private Calendar dataUpload;

	/**
	 * 
	 */
	public LivroWS() {
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
	public LivroWS(Long idLivro, String titulo, String autor, int paginas, String observacao, int pontuacao,
			boolean livroAtivo, Calendar dataUltimaLeitura, Calendar dataUpload, boolean jaFoiLido, boolean publico) {
		this.idLivro = idLivro;
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

	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
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

}
