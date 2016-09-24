package com.senac.cl.service;

import java.util.Calendar;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.senac.cl.modelos.Pessoa;
import com.senac.cl.modelos.Resenha;
import com.senac.cl.repository.ResenhaRepository;
import com.senac.cl.transactional.Transactional;

/**
 * 
 * @author Pedro
 * @since 13/09/2016
 */
public class ResenhaService {

	@Inject
	ResenhaRepository resenhaRepository;
	
	
	private HttpSession ses = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

	/**
	 * Salava uma boca resenha
	 * 
	 * @param ed
	 */
	@Transactional
	public void salvarNovaResenha(Resenha ed) {
		Pessoa pes =(Pessoa)ses.getAttribute("user"); 
		ed.setDataInicio(Calendar.getInstance());
		ed.setDataFim(Calendar.getInstance());
		ed.setInacabada(false);
		ed.setAutor(pes);
		this.resenhaRepository.inserir(ed);
	}
	/**
	 * Salvar uma resenha incompleta
	 * @param ed
	 */
	@Transactional
	public void salvarResenhaIncompleta(Resenha ed){
		Pessoa pes =(Pessoa)ses.getAttribute("user"); 
		ed.setDataInicio(Calendar.getInstance());
		ed.setInacabada(true);
		ed.setAutor(pes);
		this.resenhaRepository.inserir(ed);
	}

}
