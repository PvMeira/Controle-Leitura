package com.senac.cl.modelos;

import java.util.Calendar;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.senac.cl.repository.LeituraRepository;
import com.senac.cl.repository.LivroRepository;
import com.senac.cl.transactional.Transactional;

/**
 * 
 * @author Pedro
 * @since 11/09/2016
 */
public class LeituraService {

	@Inject
	LeituraRepository leituraRepository;

	@Inject
	LivroRepository livroRepository;

	private HttpSession ses = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	private static final String OBS = "Use aqui para publicar suas observações sobre o livro";

	/**
	 * Metodo para salvar a nova leitura
	 * 
	 * @param ed
	 */
	@Transactional
	public void salvar(Livro livroED) {
		Pessoa pessoaLogada = (Pessoa) ses.getAttribute("user");
		Leitura novaLeitura = new Leitura();

		novaLeitura.setLivro(livroED);
		novaLeitura.setLeitor(pessoaLogada);
		novaLeitura.setDataInicio(Calendar.getInstance());
		novaLeitura.setPaginaAtual(1);
		novaLeitura.setPaginaTotal(livroED.getPaginas());
		novaLeitura.setObservacao(OBS);

		Livro livroAtualizado = this.atualizarStatusLivro(livroED, false, false);
		this.livroRepository.atualizar(livroAtualizado);

		this.leituraRepository.inserir(novaLeitura);

	}

	/**
	 * Metodo para atualizar o status do livro e a data
	 * 
	 * @param ed
	 */
	private Livro atualizarStatusLivro(Livro ed, boolean var, boolean varjafoiLido) {
		ed.setLivroAtivo(var);
		ed.setJaFoiLido(var);
		ed.setDataUltimaLeitura(Calendar.getInstance());
		return ed;
	}

	/**
	 * Busca a leitura pelo id do livro
	 * 
	 * @param ed
	 * @return
	 */
	public Leitura buscaLeituraPeloId(Livro ed) {
		return this.leituraRepository.buscarPeloId(ed.getIdLivro());
	}

	/**
	 * 
	 * @param ed
	 */
	@Transactional
	public void pararLeitura(Leitura ed) {
		this.atualizarStatusLivro(ed.getLivro(), true, true);
		this.leituraRepository.deletar(ed);
	}

	/**
	 * 
	 * @param ed
	 */
	@Transactional
	public void atualizar(Leitura ed) {
		this.leituraRepository.atualizar(ed);
	}

	/**
	 * 
	 * @return
	 */
	@Transactional
	public List<Leitura> listaTodoOsRegistros() {
		return this.leituraRepository.todosOsRegistros();
	}

	/**
	 * busca todas as leituras atuais da pessoa que está logada
	 * 
	 * @return
	 */
	@Transactional
	public List<Leitura> listaTodasLeiturasPessoaLogada() {
		Pessoa pessoaLogada = (Pessoa) ses.getAttribute("user");
		List<Leitura> lista = this.leituraRepository.listaTodasLeiturasPessoaLogada(pessoaLogada.getIdPessoa());
		return lista;
	}
}
