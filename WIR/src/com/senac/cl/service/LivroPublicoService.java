package com.senac.cl.service;

import java.util.Calendar;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.senac.cl.enums.tipoAcao;
import com.senac.cl.modelos.Livro;
import com.senac.cl.modelos.LivroPublico;
import com.senac.cl.modelos.Pessoa;
import com.senac.cl.repository.LivroPublicoRepository;
import com.senac.cl.repository.LivroRepository;
import com.senac.cl.transactional.Transactional;

/**
 * 
 * @author Pedro
 * @since 25/09/2016
 */
public class LivroPublicoService {
	
	@Inject
	LivroPublicoRepository livroRepository;
	@Inject
	LivroRepository livroRepository1;
	@Inject
	LivroHistoricoService livroService;
	
	private HttpSession ses = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
/**
 * Método para salvar o livro publico, recebendo um livro normal	
 * @param ed
 * @param var
 */
	public void salvarPublico(Livro ed) {
		
		LivroPublico entidade = this.populaLivroPublico(ed);

			// Verifica se alguma campo não foi preenchido
		this.verificaCampos(entidade);
		livroRepository.inserir(entidade);
		
	}
	
	@Transactional
	public void transferirLivroPublicoParaUsuario(LivroPublico ed){
		Pessoa pessoaDaSecao = (Pessoa) this.ses.getAttribute("user");
		Livro entidade = new Livro();
		entidade.setDono(pessoaDaSecao);
		entidade.setDataUltimaLeitura(Calendar.getInstance());
		entidade.setDataUpload(Calendar.getInstance());
		
		//Copiando para nova entidade
		
		entidade.setArquivo(ed.getArquivoPublico());
		entidade.setAutor(ed.getAutorPublico());
		entidade.setObservacao(ed.getObservacaoPublico());
		entidade.setPaginas(ed.getPaginasPublico());
		entidade.setPontuacao(ed.getPontuacaoPublico());
		entidade.setTitulo(ed.getTituloPublico());
		entidade.setJaFoiLido(false);
		entidade.setPublico(true);
		entidade.setLivroAtivo(true);
		
		this.livroService.inserirLinhaHistorico(entidade, tipoAcao.INCLUIR, null);
		this.livroRepository1.inserir(entidade);
		
	}
	
	@Transactional
	public void salvarLivroPublico(LivroPublico ed) {
		
		Pessoa pessoaDaSecao = (Pessoa) this.ses.getAttribute("user");
		
		ed.setDataUltimaLeituraPublico(Calendar.getInstance());	
		ed.setDataUploadPublico(Calendar.getInstance());
		ed.setPublicoPublico(true);
		ed.setJaFoiLidoPublico(false);
		ed.setDonoPublico(pessoaDaSecao);
		
		this.verificaCampos(ed);
		livroRepository.inserir(ed);
		
	}
	
	
	
	/**
	 * Popula o livro publico, recebendo um livro e copiando-o
	 *	para a entidade Livro Publico
	 * @param ed
	 * @return
	 */
	private LivroPublico populaLivroPublico(Livro ed){
		Pessoa pessoaDaSecao = (Pessoa) this.ses.getAttribute("user");
		LivroPublico entidade = new LivroPublico();
		entidade.setDonoPublico(pessoaDaSecao);
		entidade.setDataUltimaLeituraPublico(Calendar.getInstance());
		entidade.setDataUploadPublico(Calendar.getInstance());
		
		//Copiando para nova entidade
		
		entidade.setArquivoPublico(ed.getArquivo());
		entidade.setAutorPublico(ed.getAutor());
		entidade.setObservacaoPublico(ed.getObservacao());
		entidade.setPaginasPublico(ed.getPaginas());
		entidade.setPontuacaoPublico(ed.getPontuacao());
		entidade.setTituloPublico(ed.getTitulo());
		entidade.setJaFoiLidoPublico(false);
		entidade.setPublicoPublico(true);
		
		return entidade;
	}
	/**
	 * Verifica se algum campo não foi preenchido
	 * @param livro
	 */
	@Transactional
	private void verificaCampos(LivroPublico livro) {
		if (livro.getTituloPublico() == null) {
			throw new RuntimeException("Campo Autor está nulo");
		}
		if (livro.getDonoPublico() == null) {
			throw new RuntimeException("Problema Com o login, contado suporte");
		}
		if (livro.getPaginasPublico() == 0) {
			throw new RuntimeException("Campo paginas está nulo");
		}
		if (livro.getAutorPublico() == null) {
			throw new RuntimeException("Campo autor está nulo");
		}
	}

	/**
	 * Atualiza a entidade livro recebida
	 * @param entidade
	 */
	@Transactional
	public void atualizar(Livro ed) {
		LivroPublico entidade = this.populaLivroPublico(ed);	
		livroRepository.atualizar(entidade);
	}
	/**
	 * Método para deletar 
	 * @param livro
	 */
	@Transactional
	public void deletar(LivroPublico livro) {
		livroRepository.deletar(livro);
	}
	/**
	 * Listar todos os livros Publicos
	 * @return
	 */
	@Transactional
	public List<LivroPublico> listarLivrosPublicos(){
		return this.livroRepository.todosOsRegistros();
	}
}
