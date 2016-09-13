package com.senac.cl.managed.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.senac.cl.modelos.Resenha;
import com.senac.cl.service.ResenhaService;

/**
 * 
 * @author Pedro
 * @since 13/09/2016
 */
@ManagedBean
@ViewScoped
public class ResenhaMB {

	private Resenha resenha;

	@Inject
	private ResenhaService resenhaService;

	/**
	 * Salva uma nova resenha
	 */
	public void salvarNovaResenha() {
		this.resenhaService.salvarNovaResenha(this.resenha);
		limpar();
	}

	/**
	 * salva uma reesenha incompleta, tendo a possibilidade que dps a pessoa
	 * possa continuar escrevendo
	 */
	public void salvarResenhaIncompleta() {
		this.resenhaService.salvarNovaResenha(this.resenha);
	}

	/**
	 * Limpar os campos
	 */
	public void limpar() {
		setResenha(null);
	}

	/**
	 * @return the resenha
	 */
	public Resenha getResenha() {
		if (this.resenha == null) {
			setResenha(new Resenha());
		}
		return resenha;
	}

	/**
	 * @param resenha
	 *            the resenha to set
	 */
	public void setResenha(Resenha resenha) {
		this.resenha = resenha;
	}

}
