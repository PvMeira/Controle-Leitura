package com.senac.cl.service;

import java.util.Calendar;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.senac.cl.enums.tipoAcao;
import com.senac.cl.modelos.Livro;
import com.senac.cl.modelos.LivroHistorico;
import com.senac.cl.modelos.Pessoa;
import com.senac.cl.repository.LivroHistoricoRepository;

/**
 * 
 * @author Pedro
 * @since 25/09/2016
 */
public class LivroHistoricoService {
	@Inject
	LivroHistoricoRepository repository;

	private HttpSession ses = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	/**
	 * Cria uma linha na tabela de historico
	 * @param ed
	 * @param en
	 * @param c
	 */
	public void inserirLinhaHistorico(Livro ed, tipoAcao en, Calendar c) {
		Pessoa pessoaLogada = (Pessoa) ses.getAttribute("user");

		LivroHistorico historico = new LivroHistorico();
		historico.setDataInicio(ed.getDataUpload());
		historico.setNomeLivro(ed.getAutor());
		historico.setNomePessoa(ed.getDono().getNome());
		historico.setObservacao(ed.getObservacao());
		historico.setPessoaRealizouAcaoLogin(pessoaLogada.getIdPessoa());
		historico.setDatafim(c);
		historico.setTipoAcao(en.getSigla());

		this.repository.inserir(historico);
	}
	/**
	 * Lista todos os registros da aplica��o
	 * @return
	 */
	public List<LivroHistorico> listarHistoricoLivro() {
		return repository.todosOsRegistros();
	}
	
}
