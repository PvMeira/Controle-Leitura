package com.senac.cl.managed.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.event.CaptureEvent;
import org.primefaces.event.FileUploadEvent;

import com.senac.cl.modelos.Pessoa;
import com.senac.cl.service.PessoaService;
import com.senac.cl.utilitarios.SistemaDeMensagens;

/**
 * 
 * @author Pedro
 * @since 27/08/2016
 */
@ManagedBean
@ViewScoped
public class PessoaMB {

	private Pessoa pessoa;

	private List<Pessoa> listaDePessoasRegistradas;

	@Inject
	private PessoaService servico;

	public PessoaMB() {
	}

	/**
	 * Salva um novo usuario
	 * 
	 */

	public void salvar() {
		try {
			this.verificaFoto(this.pessoa.getFotoUser());
			servico.salvar(getPessoa());
			SistemaDeMensagens.notificaINFORMACAO("Parabéns!", "Cadastro salvo com sucesso!");
			carregarListaDePessoas();
			limpar();
		} catch (IOException e) {
			SistemaDeMensagens.notificaERRO("EROOeeee!", "Cadastro salvo com sucesso!");
		}
	}

	private byte[] verificaFoto(byte[] ed) throws FileNotFoundException, IOException {
		if (this.pessoa.getFotoUser()== null) {
			byte[] conteudo = converteFileToByteArray();
			this.pessoa.setFotoUser(conteudo);
			return conteudo;
		}
		return ed;

	}

	public byte[] converteFileToByteArray() throws FileNotFoundException, IOException {
		File f = new File("C:/devHome/workspace/WIR-WEBII-Project/WIR/WebContent/resources/imagens/iconeUser.png");
		FileInputStream fs = new FileInputStream(f);
		byte[] byt = new byte[(int) f.length()];
		for (int i = 0; i < f.length(); i++) {
			byt[i] = (byte) fs.read();
		}
		fs.close();
		return byt;
	}
	
	/**
	 * Método para captura
	 * @param captureEvent
	 */
	 public void oncapture(CaptureEvent captureEvent) {
	        byte[] data = captureEvent.getData();
	        this.pessoa.setFotoUser(data);
	    }

	/**
	 * Deleta Um usuario do sistema
	 * 
	 * @param pessoa
	 */
	public void deletar(Pessoa pessoa) {
		servico.deletar(pessoa);
		limpar();
	}
	/**
	 * Retorna o nome da aba com contador
	 * @return
	 */
	
	public String nomeAbaUserAdm(){
		int num = this.getListaDePessoasRegistradas().size();
		
		String retorno = "Usuários Cadastrados".concat("("+num).concat(")");
		
		return retorno;
	}

	/**
	 * Carrega foto
	 * 
	 * @param event
	 */
	public void carregarArquivo(FileUploadEvent event) {
		byte[] conteudo = event.getFile().getContents();
		this.pessoa.setFotoUser(conteudo);
	}

	/**
	 * Metodo para limpar os campos após ação
	 */
	public void limpar() {
		setPessoa(new Pessoa());
	}

	/**
	 * metodo Set
	 */
	private void carregarListaDePessoas() {
		setListaDePessoasRegistradas(servico.carregarPessoasDoBancoDeDados());
	}

	/**
	 * 
	 * @return
	 */
	public List<Pessoa> getListaDePessoasRegistradas() {
		if (listaDePessoasRegistradas == null) {
			carregarListaDePessoas();
		}
		return listaDePessoasRegistradas;
	}

	/**
	 * 
	 * @param listaDePessoasRegistradas
	 */
	public void setListaDePessoasRegistradas(List<Pessoa> listaDePessoasRegistradas) {
		this.listaDePessoasRegistradas = listaDePessoasRegistradas;
	}

	/**
	 * 
	 * @return
	 */
	public Pessoa getPessoa() {
		if (pessoa == null) {
			limpar();
		}
		return pessoa;
	}

	/**
	 * 
	 * @param pessoa
	 */
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}