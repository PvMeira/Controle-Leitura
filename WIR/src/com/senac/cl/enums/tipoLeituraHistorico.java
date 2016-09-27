package com.senac.cl.enums;

public enum tipoLeituraHistorico {
	INICIO("I", "INICIO"), 
	FIM("F", "FIM"),
	ALTERACAO("A","ALTERACAO"),
	CANCELAMENTO("C", "CANCELAMENTO");

	private String sigla;
	private String nome;

	/**
	 * @param sigla
	 * @param nome
	 */
	private tipoLeituraHistorico(String sigla, String nome) {
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
	
	public static tipoLeituraHistorico getTipoLeituraHistoricoEnumPorSigla(String sigla){
		switch (sigla) {
			case "I":return tipoLeituraHistorico.INICIO;
			case "F":return tipoLeituraHistorico.FIM;
			case "A":return tipoLeituraHistorico.ALTERACAO;
			case "C":return tipoLeituraHistorico.CANCELAMENTO;
		}
		return null;
	}


}
