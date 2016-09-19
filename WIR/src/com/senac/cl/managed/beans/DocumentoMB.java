package com.senac.cl.managed.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.model.StreamedContent;

import com.senac.cl.modelos.Livro;
import com.senac.cl.service.DocumentoService;
import com.senac.cl.utilitarios.Documento;

/**
 * 
 * @author Pedro
 * @since 19/09/2016
 */
@ManagedBean
@ViewScoped
public class DocumentoMB {

	private Livro livro = null;
	private byte[] conteudoEmBytes = null;
	private String titulo = "";
	private String tipo = "";
	private String mimeType = "";
	@Inject
	DocumentoService docuemntoService;

	public void visualizar(Livro documento) {
		docuemntoService.visualizaDocumento(documento);
		this.livro = documento;
		conteudoEmBytes = documento.getArquivo();
		popularAtributos(documento);

	}

	public StreamedContent getFile() {
		if(this.livro.getArquivo() != null){
			docuemntoService.visualizaDocumento(this.livro);
			return Documento.getInstance().fileDownload(this.livro);	
		}else{
			return null;
		}

	}

	private void popularAtributos(Livro documento) {
		titulo = documento.getTitulo();
		tipo = ".pdf";
	}

	/**
	 * @return the livro
	 */
	public Livro getLivro() {
		return livro;
	}

	/**
	 * @param livro
	 *            the livro to set
	 */
	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	/**
	 * @return the conteudoEmBytes
	 */
	public byte[] getConteudoEmBytes() {
		return conteudoEmBytes;
	}

	/**
	 * @param conteudoEmBytes
	 *            the conteudoEmBytes to set
	 */
	public void setConteudoEmBytes(byte[] conteudoEmBytes) {
		this.conteudoEmBytes = conteudoEmBytes;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the mimeType
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * @param mimeType
	 *            the mimeType to set
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

}
