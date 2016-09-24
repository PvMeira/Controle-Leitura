package com.senac.cl.service;

import java.util.Calendar;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.senac.cl.modelos.ListaCustomizada;
import com.senac.cl.modelos.Livro;
import com.senac.cl.modelos.Pessoa;
import com.senac.cl.repository.ListaCustomizadaRepository;
import com.senac.cl.transactional.Transactional;

/**
 * 
 * @author Pedro
 * @since 13/09/2016
 */
public class ListaCustomizadaService {

	@Inject
	ListaCustomizadaRepository listaCustomizadaRepository;

	private HttpSession ses = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

	/**
	 * Método para criar uma nova Lista Customizada
	 * 
	 * @param lista
	 * @param ed
	 */
	@Transactional
	public void CriarUmaNovaLista(List<Livro> lista, ListaCustomizada ed) {
		this.validaCampos(lista, ed);
		Pessoa user = (Pessoa) ses.getAttribute("user");
		ed.setDataInclusao(Calendar.getInstance());
		ed.setPessoa(user);
//		this.populaNomeLivro(lista, ed);
		this.listaCustomizadaRepository.inserir(ed);

	}
	
	@Transactional
	public void deletarListaCustomizada(ListaCustomizada ed){
		this.listaCustomizadaRepository.deletar(ed);
	}
//	private void populaNomeLivro(List<Livro> lista, ListaCustomizada ed){
//		List<String> list = null;
//		for (Livro livro : lista) {
//			list.add(livro.getTitulo());
//		}
//		ed.setLivro(list);
//	}

	/**
	 * Valida os campos da modal de nova Lista customizada
	 * 
	 * @param lista
	 * @param ed
	 */
	private void validaCampos(List<Livro> lista, ListaCustomizada ed) {
		if (lista.isEmpty() || lista.equals(null)) {
			throw new RuntimeException("Livro(s) não selecionados");
		} else {
			if (ed.getNomeLista() == null) {
				throw new RuntimeException("Nome da Lista  não preenchido");
			} else {
				if (ed.getTipoLista() == null) {
					throw new RuntimeException("Tipo da Lista  não preenchido");
				}

			}
		}
	}
	public List<ListaCustomizada> listarTodasListadasCustumizadasDoSistema(){
		return this.listaCustomizadaRepository.todosOsRegistros();
	}
	public void removeListaCustomizadaPeloLivro(ListaCustomizada ed){
		this.listaCustomizadaRepository.deletar(ed);
	}

	public List<ListaCustomizada> listarListasCustomizadas() {
		Pessoa user = (Pessoa) ses.getAttribute("user");
		List<ListaCustomizada> lista = this.listaCustomizadaRepository.listaRegistrosPessoaLogada(user.getIdPessoa());
		return lista;
	}
}
