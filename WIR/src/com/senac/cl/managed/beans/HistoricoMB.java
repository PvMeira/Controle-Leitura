package com.senac.cl.managed.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.senac.cl.enums.tipoAcao;
import com.senac.cl.enums.tipoLeituraHistorico;
import com.senac.cl.modelos.LeituraHistorico;
import com.senac.cl.modelos.LivroHistorico;
import com.senac.cl.modelos.Pessoa;
import com.senac.cl.modelos.PessoaHistorico;
import com.senac.cl.service.LeituraHistoricoService;
import com.senac.cl.service.LivroHistoricoService;
import com.senac.cl.service.PessoaHistoricoService;
import com.senac.cl.service.PessoaService;

/**
 * 
 * @author Pedro Vargas
 * @since 23/09/2016
 */
@ManagedBean
@ViewScoped
public class HistoricoMB {

	@Inject
	LivroHistoricoService livroHistorico;

	@Inject
	PessoaHistoricoService pessoaHistorico;
	
	@Inject
	PessoaService pessoaService;

	@Inject
	LeituraHistoricoService leituraHistorico;
	
	/**
	 * Lista historico Livro
	 * @return
	 */
	public List<LivroHistorico> listarhistoricoLivro() {
		List<LivroHistorico> lista = this.livroHistorico.listarHistoricoLivro();
		return lista;
	}
	/**
	 * lista Historico Pessoa
	 * @return
	 */
	public List<PessoaHistorico> listarhistoricoPessoa() {
		List<PessoaHistorico> lista = this.pessoaHistorico.listaHistoricoPessoa();
		return lista;
	}
	/**
	 * Lista historico leitura
	 * @return
	 */
	public List<LeituraHistorico> listarhistoricoLeitura() {
		List<LeituraHistorico> lista = this.leituraHistorico.listaHistoricoLeitura();
		return lista;
	}
	
	/**
	 * Busca o nome do funcionario que realizou ação
	 * @param id
	 * @return
	 */
	public String buscaPessoaRealizouAcao(long id) {

		Pessoa pes = this.pessoaService.buscaPessoaPeloId(id);
		if (pes != null) {
			return pes.getNome();
		} else {
			return "Sem Usuário";
		}
	}
	
	/**
	 * Devolve nome aba Livro-Historico
	 * @return
	 */
	public String abaHisLivro(){
			int cont = this.listarhistoricoLivro().size();
			String s = "Movimentação-Livro".concat("("+cont).concat(")");
		return s;
	}
	
	/**
	 * Devolve nome aba Pessoa-Historico
	 * @return
	 */
	public String abaHisPessoa(){
			int cont = this.listarhistoricoPessoa().size();
			String s = "Movimentação-Usuário".concat("("+cont).concat(")");
		return s;
	}
	
	/**
	 * Devolve nome aba Leitura-Historico
	 * @return
	 */
	public String abaHisLeitura(){
			int cont = this.listarhistoricoLeitura().size();
			String s = "Movimentação-Leitura".concat("("+cont).concat(")");
		return s;
	}
	
	/**
	 * Conversor enum pessoa
	 * @param ed
	 * @return
	 */
	public String conversorAcaoEnumPessoa(PessoaHistorico ed){
		return tipoAcao.getTipoAcaoEnumPorSigla(ed.getTipoAcao()).getNome();
	}
	
	/**
	 * Conversor enum livro
	 * @param ed
	 * @return
	 */
	public String conversorAcaoEnumLivro(LivroHistorico ed){
		return tipoAcao.getTipoAcaoEnumPorSigla(ed.getTipoAcao()).getNome();
	}
	
	/**
	 * Conversor acao leitura
	 * @param ed
	 * @return
	 */
	public String conversorAcaoEnumleitura(LeituraHistorico ed){
		return tipoLeituraHistorico.getTipoLeituraHistoricoEnumPorSigla(ed.getTipoAcao()).getNome();
	}
}
