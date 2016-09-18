package com.senac.cl.service;

import java.util.Calendar;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.senac.cl.enums.tipoLeituraHistorico;
import com.senac.cl.modelos.Leitura;
import com.senac.cl.modelos.LeituraHistorico;
import com.senac.cl.modelos.Pessoa;
import com.senac.cl.repository.LeituraHistoricoRepository;

public class LeituraHistoricoService {

	@Inject
	LeituraHistoricoRepository repository;

	private HttpSession ses = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

	public void inserirLinhaHistorico(Leitura ed, tipoLeituraHistorico en, Calendar c) {
		Pessoa pessoaLogada = (Pessoa) ses.getAttribute("user");

		LeituraHistorico historico = new LeituraHistorico();
		historico.setDataInicio(ed.getDataInicio());
		historico.setNomeLivro(ed.getLivro().getTitulo());
		historico.setNomePessoa(ed.getLeitor().getNome());
		historico.setObservação(ed.getObservacao());
		historico.setPessoaRealizouAcaoLogin(pessoaLogada.getIdPessoa());
		historico.setDatafim(c);
		historico.setTipoAcao(en.getSigla());

		this.repository.inserir(historico);
	}

}
