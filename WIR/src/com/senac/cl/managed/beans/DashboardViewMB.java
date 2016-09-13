package com.senac.cl.managed.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

import com.senac.cl.service.LivroService;

/**
 * 
 * @author Pedro
 * @since 12/09/2016
 */
@ManagedBean
@ViewScoped
public class DashboardViewMB implements Serializable {

	private static final long serialVersionUID = 5345477542305231961L;

	private DashboardModel model;
	
	@Inject
	private LivroService livroService;

	@PostConstruct
	public void init() {
		model = new DefaultDashboardModel();
		DashboardColumn column1 = new DefaultDashboardColumn();
		DashboardColumn column2 = new DefaultDashboardColumn();

		column1.addWidget("livros");
		column1.addWidget("usuarios");

		column2.addWidget("dados");
		column2.addWidget("extras");

		model.addColumn(column1);
		model.addColumn(column2);

	}
	
	
	/**
	 * Retorna o numero total de livros cadastrados no sistema
	 * @return
	 */
	public int contaLivrosTotais(){
		return this.livroService.contaLivrosTotais();
	}
	
	/**
	 * Retorna o numero  de livros Publicos cadastrados no sistema
	 * @return
	 */
	public int contaLivrosPublicosTotais(){
		return this.livroService.contaLivrosPublicosTotais();
	}
	
	

	/**
	 * @return the model
	 */
	public DashboardModel getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(DashboardModel model) {
		this.model = model;
	}

}
