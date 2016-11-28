package webService;

public class LivroWS {
	private int idLivro;
	private String nomeLivro;
	private String nomeAutor;
	private String nomeDono;
	private int paginas;
	private int pontuacao;

	/**
	 * 
	 */
	public LivroWS() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nomeLivro
	 * @param nomeAutor
	 * @param nomeDono
	 * @param paginas
	 * @param pontuacao
	 */
	public LivroWS(String nomeLivro, String nomeAutor, String nomeDono, int paginas, int pontuacao, int idLivro) {
		this.nomeLivro = nomeLivro;
		this.nomeAutor = nomeAutor;
		this.nomeDono = nomeDono;
		this.paginas = paginas;
		this.pontuacao = pontuacao;
		this.idLivro = idLivro;
	}

	/**
	 * @return the nomeLivro
	 */
	public String getNomeLivro() {
		return nomeLivro;
	}

	/**
	 * @param nomeLivro
	 *            the nomeLivro to set
	 */
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	/**
	 * @return the nomeAutor
	 */
	public String getNomeAutor() {
		return nomeAutor;
	}

	/**
	 * @param nomeAutor
	 *            the nomeAutor to set
	 */
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	/**
	 * @return the nomeDono
	 */
	public String getNomeDono() {
		return nomeDono;
	}

	/**
	 * @param nomeDono
	 *            the nomeDono to set
	 */
	public void setNomeDono(String nomeDono) {
		this.nomeDono = nomeDono;
	}

	/**
	 * @return the paginas
	 */
	public int getPaginas() {
		return paginas;
	}

	/**
	 * @param paginas
	 *            the paginas to set
	 */
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	/**
	 * @return the pontuacao
	 */
	public int getPontuacao() {
		return pontuacao;
	}

	/**
	 * @param pontuacao
	 *            the pontuacao to set
	 */
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	/**
	 * @return the idLivro
	 */
	public int getIdLivro() {
		return idLivro;
	}

	/**
	 * @param idLivro
	 *            the idLivro to set
	 */
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

}
