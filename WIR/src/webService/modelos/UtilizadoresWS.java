package webService.modelos;

public class UtilizadoresWS {

	private int id;
	private String nome;
	private String data;
	private int livrosCompartilhados;

	/**
	 * 
	 */
	public UtilizadoresWS() {
	}

	/**
	 * @param id
	 * @param nome
	 * @param data
	 * @param livrosCompartilhados
	 */
	public UtilizadoresWS(int id, String nome, String data, int livrosCompartilhados) {
		this.id = id;
		this.nome = nome;
		this.data = data;
		this.livrosCompartilhados = livrosCompartilhados;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return the livrosCompartilhados
	 */
	public int getLivrosCompartilhados() {
		return livrosCompartilhados;
	}

	/**
	 * @param livrosCompartilhados
	 *            the livrosCompartilhados to set
	 */
	public void setLivrosCompartilhados(int livrosCompartilhados) {
		this.livrosCompartilhados = livrosCompartilhados;
	}

}
