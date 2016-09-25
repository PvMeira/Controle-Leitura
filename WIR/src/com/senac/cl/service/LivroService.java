package com.senac.cl.service;

import java.util.Calendar;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.senac.cl.enums.tipoAcao;
import com.senac.cl.modelos.Livro;
import com.senac.cl.modelos.Pessoa;
import com.senac.cl.repository.LivroRepository;
import com.senac.cl.transactional.Transactional;
/**
 * @author Pedro
 * @since 25/09/2016
 */
public class LivroService {

	@Inject
	LivroRepository livroRepository;

	@Inject
	ListaCustomizadaService listaCustomizadaService;

	@Inject
	LivroHistoricoService livroHistoricoService;
	
	@Inject
	LivroPublicoService livroPublicoService;

	private HttpSession ses = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);


	/**
	 * Salva um livro
	 * @param entidade
	 */
	@Transactional
	public void salvar(Livro entidade, boolean var) {
		if (entidade.getIdLivro() != null) {
			this.atualizar(entidade);
		} else {
		
				Pessoa pessoaDaSecao = (Pessoa) this.ses.getAttribute("user");
				entidade.setDono(pessoaDaSecao);
				entidade.setDataUltimaLeitura(Calendar.getInstance());
				entidade.setDataUpload(Calendar.getInstance());
				entidade.setLivroAtivo(true);
				entidade.setPublico(var);
	
				// Verifica se alguma campo não foi preenchido
				this.verificaCampos(entidade);
				livroHistoricoService.inserirLinhaHistorico(entidade, tipoAcao.INCLUIR, null);
				livroRepository.inserir(entidade);
			
		}
	}

	/**
	 * Atualiza a entidade livro recebida
	 * @param entidade
	 */
	public void atualizar(Livro entidade) {
		entidade.setDataUpload(Calendar.getInstance());
		livroHistoricoService.inserirLinhaHistorico(entidade, tipoAcao.ALTERACAO, entidade.getDataUpload());
		livroRepository.atualizar(entidade);
	}

	/**
	 * Atualiza a boolean que torna o livro público
	 * @param entidade
	 */
	@Transactional
	public void atualizarATransferenciaParaPublico(Livro entidade) {
		entidade.setPublico(Boolean.TRUE);
		livroHistoricoService.inserirLinhaHistorico(entidade, tipoAcao.ALTERACAO, entidade.getDataUpload());
		livroRepository.atualizar(entidade);
	}


	/**
	 * verifica Se todos os campo obrigatorios estão preenchidos
	 */
	@Transactional
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
	 * 
	 * @param livro
	 */
	@Transactional
	public void deletar(Livro livro) {
		livroHistoricoService.inserirLinhaHistorico(livro, tipoAcao.DELETAR, livro.getDataUpload());
		livroRepository.deletar(livro);
	}

	/**
	 * Conta livros cadastrados
	 * 
	 * @return
	 */
	@Transactional
	public int contaLivrosTotais() {
		return this.livroRepository.contaLivrosCadastrados();
	}

	/**
	 * Conta livros publicos cadastrados
	 * 
	 * @return
	 */
	@Transactional
	public int contaLivrosPublicosTotais() {
		return this.livroRepository.contaLivrosPublicosCadastrados();
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
	 * 
	 * @return
	 */
	public List<Livro> listarTodosLivrosDoUsuario() {
		Pessoa pessoaDaSecao = (Pessoa) this.ses.getAttribute("user");
		Long idParaPesquisa = pessoaDaSecao.getIdPessoa();
		List<Livro> lista = this.livroRepository.todosOsRegistrosDoUsuario(idParaPesquisa);
		return lista;
	}

	/**
	 * retorna todos os livros marcados como publicos
	 * 
	 * @return
	 */
	public List<Livro> listaTodosLivrosPublicos() {
		List<Livro> lista = this.livroRepository.todosOsRegistrosPublicos();
		return lista;
	}

	/**
	 * Retorna o auto complete
	 * 
	 * @param s
	 * @return
	 */
	public List<Livro> listarLivrosAutoComplete(String s) {
		List<Livro> lista = this.livroRepository.listarLivrosAutoComplete(s);
		return lista;
	}

	/**
	 * Retorna o autocomplete para a transferencia onde os livros que tem
	 * publico = false serão mostrado
	 * 
	 * @param s
	 * @return
	 */
	public List<Livro> listarLivrosAutoCompleteTransferir(String s) {
		List<Livro> lista = this.livroRepository.listarLivrosAutoCompleteTransferir(s);
		return lista;
	}
	/**
	 * Auto complete para resenha
	 * @param s
	 * @return
	 */
	public List<Livro> listarLivrosAutoCompleteResenha(String s) {
		List<Livro> lista = this.livroRepository.listarLivrosAutoCompleteResenha(s);
		return lista;
	}

	/**
	 * @return the ses
	 */
	public HttpSession getSes() {
		return ses;
	}

	/**
	 * @param ses
	 *            the ses to set
	 */
	public void setSes(HttpSession ses) {
		this.ses = ses;
	}

}
