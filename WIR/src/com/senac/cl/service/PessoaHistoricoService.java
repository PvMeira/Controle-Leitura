package com.senac.cl.service;

import java.util.Calendar;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.senac.cl.enums.tipoAcao;
import com.senac.cl.modelos.Pessoa;
import com.senac.cl.modelos.PessoaHistorico;
import com.senac.cl.repository.PessoaHistoricoRepository;

/**
 * 
 * @author Pedro
 *
 */
public class PessoaHistoricoService {

	@Inject
	private PessoaHistoricoRepository repository;
	
	private HttpSession ses = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	/**
	 * Atualiza o historico setando os paramentos de acao e data
	 * @param pessoa
	 * @param tipo
	 */
	public void atualizarHistorico(Pessoa pessoa, tipoAcao tipo) {
		Pessoa pessoaLogada = (Pessoa) ses.getAttribute("user");
		PessoaHistorico ph = new PessoaHistorico();
		if(pessoaLogada != null){
			ph.setNomeUsuario(pessoaLogada.getNome());	
		}else{
			ph.setNomeUsuario("Novo Usuário");	
		}
		
		ph.setNomelogin(pessoa.getNome());
		ph.setTipoAcao(tipo.getSigla());
		ph.setDataAcao(Calendar.getInstance());
		
		repository.AtualizarHistorico(ph);
	}
	
	public List<PessoaHistorico> listaHistoricoPessoa(){
		return this.repository.todosOsRegistros();
	}

}
