package com.senac.cl.utilitarios;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Classe com varias formata��es e metodos para data
 * 
 * @author Pedro
 * @since 12/09/2016
 *
 */
public class Data {

	@SuppressWarnings("unused")
	private static final Calendar DATA_AGORA = Calendar.getInstance();

	/**
	 * metodo que Retorna Data no formato Brasileiro J� formatada s� que
	 * Retornando EX : Segunda-feira, 12 de Setembro de 2016
	 * 
	 * @param c
	 * @return
	 */
	public String getDataFormatoPTbrInteira(Calendar c) {
		Date data = c.getTime();
		DateFormat dataFormatada = DateFormat.getDateInstance(DateFormat.FULL);
		String dataFinalFormatada = " ".concat(dataFormatada.format(data));

		return dataFinalFormatada;
	}

	/**
	 * Metodo que retorna Data no formato brasileiro J� formara so que
	 * Retornando EX :12 de Setembro de 2016
	 * 
	 * @param c
	 * @return
	 */
	public String getDataFormatoPTbrLonga(Calendar c) {
		Date data = c.getTime();
		DateFormat dataFormatada = DateFormat.getDateInstance(DateFormat.LONG);
		String dataFinalFormatada = " ".concat(dataFormatada.format(data));

		return dataFinalFormatada;
	}

	/**
	 * Metodo que retorna Data no formato brasileiro J� formara so que
	 * Retornando EX :12/09/2016
	 * 
	 * @param c
	 * @return
	 */
	public String getDataFormatoPTbrMedia(Calendar c) {
		Date data = c.getTime();
		DateFormat dataFormatada = DateFormat.getDateInstance(DateFormat.MEDIUM);
		String dataFinalFormatada = " ".concat(dataFormatada.format(data));

		return dataFinalFormatada;
	}

	/**
	 * Metodo que retorna Data no formato brasileiro J� formara so que
	 * Retornando EX :12/09/16
	 * 
	 * @param c
	 * @return
	 */
	public String getDataFormatoPTbrCurta(Calendar c) {
		Date data = c.getTime();
		DateFormat dataFormatada = DateFormat.getDateInstance(DateFormat.SHORT);
		String dataFinalFormatada = " ".concat(dataFormatada.format(data));

		return dataFinalFormatada;
	}

}
