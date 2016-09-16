package com.senac.cl.managed.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.senac.cl.enums.tipoListaCustomizada;
import com.senac.cl.modelos.ListaCustomizada;
import com.senac.cl.modelos.Livro;
import com.senac.cl.service.ListaCustomizadaService;

@ManagedBean
@ViewScoped
public class ListaCustomizadaMB {

	private ListaCustomizada listaCustomizada;
	private List<Livro> livrosSelecionadosCustomizada;

	@Inject
	private ListaCustomizadaService listaCustomizadaService;

	public void criarListaCustomizada() {
		List<Livro> lista = this.livrosSelecionadosCustomizada;
		this.listaCustomizadaService.CriarUmaNovaLista(lista, this.listaCustomizada);
	}
	
	public tipoListaCustomizada[] getTipoLista() {
		return tipoListaCustomizada.values();
	}


	public List<ListaCustomizada> listarTodasListasCustomizadas() {
		return this.listaCustomizadaService.listarListasCustomizadas();
	}

	/**
	 * @return the listaCustomizada
	 */
	public ListaCustomizada getListaCustomizada() {
		if (this.listaCustomizada == null) {
			this.listaCustomizada = new ListaCustomizada();
		}
		return listaCustomizada;
	}

	/**
	 * @param listaCustomizada
	 *            the listaCustomizada to set
	 */
	public void setListaCustomizada(ListaCustomizada listaCustomizada) {
		this.listaCustomizada = listaCustomizada;
	}

	/**
	 * @return the livrosSelecionadosCustomizada
	 */
	public List<Livro> getLivrosSelecionadosCustomizada() {
		if (this.livrosSelecionadosCustomizada == null) {
			this.livrosSelecionadosCustomizada = new ArrayList<Livro>();
		}
		return livrosSelecionadosCustomizada;
	}

	/**
	 * @param livrosSelecionadosCustomizada
	 *            the livrosSelecionadosCustomizada to set
	 */
	public void setLivrosSelecionadosCustomizada(List<Livro> livrosSelecionadosCustomizada) {
		this.livrosSelecionadosCustomizada = livrosSelecionadosCustomizada;
	}

}
