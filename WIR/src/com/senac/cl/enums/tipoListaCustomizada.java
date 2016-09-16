package com.senac.cl.enums;

import java.util.List;

public enum tipoListaCustomizada {

	ACAO("Ação", 1), 
	AVENTURA("Aventura", 2), 
	COMEDIA("Comedia", 3), 
	INFORMATICA("Informatica",4), 
	QUADRINHOS("Quadrinho", 5), 
	MANGAS("Mangá", 6),;

	/**
	 * @param name
	 * @param ordinal
	 */
	tipoListaCustomizada(String name, int ordinal) {

	}

	String nomeSimples = name();
	String generoDE = name();
	int valorIntEnum = ordinal();


	/**
	 * @return the nomeSimples
	 */
	public String getNomeSimples() {
		return nomeSimples;
	}

	/**
	 * @param nomeSimples
	 *            the nomeSimples to set
	 */
	public void setNomeSimples(String nomeSimples) {
		this.nomeSimples = nomeSimples;
	}

	/**
	 * @return the generoDE
	 */
	public String getGeneroDE() {
		return generoDE;
	}

	/**
	 * @param generoDE
	 *            the generoDE to set
	 */
	public void setGeneroDE(String generoDE) {
		this.generoDE = generoDE;
	}

	/**
	 * @return the valorIntEnum
	 */
	public int getValorIntEnum() {
		return valorIntEnum;
	}

	/**
	 * @param valorIntEnum
	 *            the valorIntEnum to set
	 */
	public void setValorIntEnum(int valorIntEnum) {
		this.valorIntEnum = valorIntEnum;
	}

}
