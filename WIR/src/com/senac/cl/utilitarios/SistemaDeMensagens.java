package com.senac.cl.utilitarios;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
/**
 * 
 * @author Pedro
 * @since 27/08/2016
 */

/**
 * 
 * Classe para Criação das mensagens do sistema
 *
 */
public class SistemaDeMensagens {
/**
 * Notifica um Erro- 
 * Cor vermelho
 * @param errorMessenge
 * @param details
 */
	public static void notificaERRO(String errorMessenge, String details){
		notifica(FacesMessage.SEVERITY_ERROR, errorMessenge, details);
	}
/**
 * Notifica um aviso
 * Cor amarela	
 * @param warningMessenge
 * @param details
 */
	public static void notificaAVISO(String warningMessenge, String details){
		notifica(FacesMessage.SEVERITY_WARN, warningMessenge, details);
	}
/**
 * Notifica uma Informação
 * Cor Azul
 * @param informationMessenge
 * @param detail
 */
	public static void notificaINFORMACAO(String informationMessenge, String detail){
		notifica(FacesMessage.SEVERITY_INFO,	informationMessenge, detail);
	}
	/**
	 * Cria uma instancia de faces messenger
	 * @param severity
	 * @param messenge
	 * @param details
	 */
	private static void notifica(FacesMessage.Severity severity, String messenge, String details){
		FacesMessage mensagem = new FacesMessage(severity,	messenge, details);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}
}
