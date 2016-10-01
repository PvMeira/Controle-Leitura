package com.senac.cl.managed.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.senac.cl.enums.tipoResenha;
import com.senac.cl.modelos.Resenha;
import com.senac.cl.service.ResenhaService;
import com.senac.cl.utilitarios.SistemaDeMensagens;

/**
 * 
 * @author Pedro
 * @since 13/09/2016
 */
@ManagedBean
@ViewScoped
public class ResenhaMB {

	private Resenha resenha;
	private Resenha resenhaModal;
	private static final String SEM_CONTENT = "Sem Conteúdo";

	@Inject
	private ResenhaService resenhaService;

	/**
	 * Salva uma nova resenha
	 */
	public void salvarNovaResenha() {
		if (this.resenha.getConteudo().trim().isEmpty() == false && this.resenha.getTitulo().trim().isEmpty() == false
				&& this.resenha.getAssunto().trim().isEmpty() == false) {
			this.resenhaService.salvarNovaResenha(this.resenha);
			SistemaDeMensagens.notificaINFORMACAO("Cadastro Salvo com Sucesso", "");
			limpar();
		} else {
			this.salvarResenhaIncompleta();
			limpar();
		}
	}

	/**
	 * salva uma reesenha incompleta, tendo a possibilidade que dps a pessoa
	 * possa continuar escrevendo
	 */
	public void salvarResenhaIncompleta() {
		this.resenhaService.salvarResenhaIncompleta(this.resenha);
		SistemaDeMensagens.notificaINFORMACAO("Cadastro incompleto Salvo com Sucesso", "");
		limpar();
	}

	public String conversorTipoResenha(Resenha ed) {
		return tipoResenha.getTipoResenhaEnumPorSigla(ed.getTipoResenha()).getNome();
	}

	public String retornaContent(Resenha ed) {
		if (ed.getConteudo() != null) {
			return ed.getConteudo();
		} else {
			return SEM_CONTENT;
		}

	}

	/**
	 * Lista resenhas completadas
	 * 
	 * @return
	 */
	public List<Resenha> listaResenhasUsuarioAcabadas() {
		return this.resenhaService.listaResenhaUsuarioAcabadas();
	}

	/**
	 * Lista Resenhas inacabadas pelo usuario
	 * 
	 * @return
	 */
	public List<Resenha> listaResenhasUsuarioInacabadas() {
		return this.resenhaService.listaResenhaUsuarioInacabadas();
	}

	/**
	 * retorna os tipos de resenhas da Enum
	 * 
	 * @return
	 */
	public tipoResenha[] getTipoResenha() {
		return tipoResenha.values();
	}

	/**
	 * Limpar os campos
	 */
	public void limpar() {
		setResenha(null);
	}

	/**
	 * @return the resenha
	 */
	public Resenha getResenha() {
		if (this.resenha == null) {
			setResenha(new Resenha());
		}
		return resenha;
	}

	/**
	 * @param resenha
	 *            the resenha to set
	 */
	public void setResenha(Resenha resenha) {
		this.resenha = resenha;
	}

	/**
	 * @return the resenhaModal
	 */
	public Resenha getResenhaModal() {
		return resenhaModal;
	}

	/**
	 * @param resenhaModal
	 *            the resenhaModal to set
	 */
	public void setResenhaModal(Resenha resenhaModal) {
		this.resenhaModal = resenhaModal;
	}

}
