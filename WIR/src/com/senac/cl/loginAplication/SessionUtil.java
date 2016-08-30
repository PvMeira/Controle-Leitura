package com.senac.cl.loginAplication;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
/**
 * 
 * @author Pedro
 * @since 27/08/2016
 */
public class SessionUtil implements Serializable {

	/**
	 * Classe para trabalhar com Http, session e etc 
	 */
	private static final long serialVersionUID = 1L;
/**
 * Retorn a sessao
 * @return
 */
	public static HttpSession getSession() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpSession sessao = (HttpSession) ctx.getExternalContext().getSession(false);
		return sessao;
	}
/**
 * faz um SET em um paramentro da sessao
 * @param key
 * @param value
 */
	public static void setParam(String key, Object value) {
		getSession().setAttribute(key, value);
	}
/**
 * retorna um paramentro de um sesssao
 * @param key
 * @return
 */
	public static Object getParam(String key) {
		return getSession().getAttribute(key);
	}
/**
 * Remove um atributo especifico de uma sessao
 * @param key
 */
	public static void remove(String key) {
		getSession().removeAttribute(key);
	}
/**
 * invalida uma sessão
 */
	public static void invalidate() {
		getSession().invalidate();
	}
}