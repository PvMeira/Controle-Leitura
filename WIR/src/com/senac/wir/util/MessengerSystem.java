package com.senac.wir.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessengerSystem {

	public static void notifyError(String errorMessenge, String details){
		notify(FacesMessage.SEVERITY_ERROR, errorMessenge, details);
	}
	
	public static void notifyWarning(String warningMessenge, String details){
		notify(FacesMessage.SEVERITY_WARN, warningMessenge, details);
	}
	
	public static void notifyInformation(String informationMessenge, String detail){
		notify(FacesMessage.SEVERITY_INFO,	informationMessenge, detail);
	}
	
	private static void notify(FacesMessage.Severity severity, String messenge, String details){
		FacesMessage msg = new FacesMessage(severity,	messenge, details);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
