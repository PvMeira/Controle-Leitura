package com.senac.cl.service;

import java.util.Calendar;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;


import com.senac.cl.modelos.Livro;
import com.senac.cl.modelos.Pessoa;
import com.senac.cl.repository.LivroRepository;
import com.senac.cl.transactional.Transactional;

public class LivroService {

	@Inject
	LivroRepository livroRepository;
	
	private HttpSession ses = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	

	
	/**
	 * Salva um livro 
	 * @param entidade
	 */
	@Transactional
	public void salvar(Livro entidade) {
		Pessoa pessoaDaSecao = (Pessoa)this.ses.getAttribute("user");
		
		entidade.setDono(pessoaDaSecao);
		entidade.setDataUltimaLeitura(Calendar.getInstance());
		entidade.setDataUpload(Calendar.getInstance());
		entidade.setLivroAtivo(true);
		
		// Verifica se alguma campo não foi preenchido
		this.verificaCampos(entidade);
		livroRepository.inserir(entidade);
	}
	
	/**
	 * Atualiza a entidade livro recebida
	 * @param entidade
	 */
	@Transactional
	public void atualizar (Livro entidade){
		entidade.setDataUpload(Calendar.getInstance());
		livroRepository.atualizar(entidade);
	}

	/**
	 * verifica Se todos os campo obrigatorios estão preenchidos
	 */
	private void verificaCampos(Livro livro) {
		if (livro.getTitulo() == null) {
			throw new RuntimeException("Campo Autor está nulo");
		}
		if (livro.getDono() == null) {
			throw new RuntimeException("Problema Com o login, contado suporte");
		}
		if (livro.getPaginas() == 0) {
			throw new RuntimeException("Campo paginas está nulo");
		}
		if (livro.getAutor() == null) {
			throw new RuntimeException("Campo autor está nulo");
		}
	}

	/**
	 * Remove o livro selecionado da lista 
	 * @param livro
	 */
	@Transactional
	public void deletar(Livro livro) {
		livroRepository.deletar(livro);

	}
	/**
	 * 
	 * @return
	 */
	@Transactional
	public List<Livro> listarTodosRegistros() {
		return livroRepository.todosOsRegistros();
	}
	
	/**
	 * retorna os livros da pessoa logada
	 * @return
	 */
	public List<Livro> listarTodosLivrosDoUsuario(){
		Pessoa pessoaDaSecao = (Pessoa)this.ses.getAttribute("user");
		Long idParaPesquisa = pessoaDaSecao.getIdPessoa();
		List<Livro> lista = this.livroRepository.todosOsRegistrosDoUsuario(idParaPesquisa);
		return lista;
	}

	/**
	 * @return the ses
	 */
	public HttpSession getSes() {
		return ses;
	}

	/**
	 * @param ses the ses to set
	 */
	public void setSes(HttpSession ses) {
		this.ses = ses;
	}

}
