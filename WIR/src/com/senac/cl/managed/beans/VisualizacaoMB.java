package com.senac.cl.managed.beans;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.senac.cl.modelos.Livro;



@ManagedBean
@SessionScoped
public class VisualizacaoMB implements Serializable{

	private static final long serialVersionUID = 1040451429018153126L;
	
	private Livro livroVisualizacao;
	
	private static final String CONTENT_TYPE= "application/pdf";
	
	private String nomeLivro ;
	
	private DefaultStreamedContent conteudo;

	private ByteArrayInputStream conteudoBytes;
	
	private byte[] bytesLivro;
	
	
    public void populaLivroVisualizacao(Livro l) throws IOException{
    	this.limpaDadosStream();
    	this.livroVisualizacao = l;
    	this.populaConteudoVisualizacao(this.livroVisualizacao);
    }

	
	private void populaConteudoVisualizacao(Livro livro) throws IOException {
		this.conteudoBytes = new ByteArrayInputStream(livro.getArquivo());
		this.bytesLivro = livro.getArquivo();
		this.nomeLivro = livro.getTitulo();		
		this.conteudo = new DefaultStreamedContent(this.conteudoBytes, CONTENT_TYPE, this.nomeLivro + ".pdf");
	}
	public StreamedContent viewLivro(){
		return this.conteudo;
	}
	
	private void limpaDadosStream(){
		this.conteudo = null;
		this.nomeLivro = null;
		this.conteudoBytes = null;
	}
	/**
	 * @return the livroVisualizacao
	 */
	public Livro getLivroVisualizacao() {
		return livroVisualizacao;
	}
	/**
	 * @param livroVisualizacao the livroVisualizacao to set
	 */
	public void setLivroVisualizacao(Livro livroVisualizacao) {
		this.livroVisualizacao = livroVisualizacao;
	}
	/**
	 * @return the nomeLivro
	 */
	public String getNomeLivro() {
		return nomeLivro;
	}
	/**
	 * @param nomeLivro the nomeLivro to set
	 */
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	/**
	 * @return the conteudo
	 */
	public DefaultStreamedContent getConteudo() {
		return conteudo;
	}
	/**
	 * @param conteudo the conteudo to set
	 */
	public void setConteudo(DefaultStreamedContent conteudo) {
		this.conteudo = conteudo;
	}
	/**
	 * @return the conteudoBytes
	 */
	public ByteArrayInputStream getConteudoBytes() {
		return conteudoBytes;
	}
	/**
	 * @param conteudoBytes the conteudoBytes to set
	 */
	public void setConteudoBytes(ByteArrayInputStream conteudoBytes) {
		this.conteudoBytes = conteudoBytes;
	}


	/**
	 * @return the bytesLivro
	 */
	public byte[] getBytesLivro() {
		return bytesLivro;
	}


	/**
	 * @param bytesLivro the bytesLivro to set
	 */
	public void setBytesLivro(byte[] bytesLivro) {
		this.bytesLivro = bytesLivro;
	}
	
	
 
}
