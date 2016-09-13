package com.senac.cl.enums;

/**
 * Tipos de resenha
 * 
 * @author Pedro
 *
 */
public enum tipoResenha {

	CRITICA("C", "Crítica"), 
	DESCRITIVA("D", "Descritiva"), 
	TEMATICA("T", "Temática"), 
	LITERARIA("L", "Literária");

	private String sigla;
	private String nome;

	/**
	 * @param sigla
	 * @param nome
	 */
	private tipoResenha(String sigla, String nome) {
		this.sigla = sigla;
		this.nome = nome;
	}

	/**
	 * @return the sigla
	 */
	public String getSigla() {
		return sigla;
	}

	/**
	 * @param sigla
	 *            the sigla to set
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
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

}
