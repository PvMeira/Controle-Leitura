package com.senac.cl.utilitarios;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class SistemaDeMensagens {

	public static void notificaERRO(String errorMessenge, String details){
		notifica(FacesMessage.SEVERITY_ERROR, errorMessenge, details);
	}
	
	public static void notificaAVISO(String warningMessenge, String details){
		notifica(FacesMessage.SEVERITY_WARN, warningMessenge, details);
	}
	
	public static void notificaINFORMACAO(String informationMessenge, String detail){
		notifica(FacesMessage.SEVERITY_INFO,	informationMessenge, detail);
	}
	
	private static void notifica(FacesMessage.Severity severity, String messenge, String details){
		FacesMessage mensagem = new FacesMessage(severity,	messenge, details);
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}
}
