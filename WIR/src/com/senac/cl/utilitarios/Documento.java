package com.senac.cl.utilitarios;

import java.io.ByteArrayInputStream;

import org.primefaces.model.DefaultStreamedContent;

import com.senac.cl.modelos.Livro;

public class Documento {
	private static Documento instance = null;

	protected Documento() {
	};

	public static Documento getInstance() {
		if (instance == null) {
			instance = new Documento();
		}
		return instance;
	}
	public DefaultStreamedContent fileDownload(Livro documento) {
		ByteArrayInputStream stream = new ByteArrayInputStream(documento.getArquivo());
		return new DefaultStreamedContent(stream, "application/pdf", documento.getTitulo());
	}
}
