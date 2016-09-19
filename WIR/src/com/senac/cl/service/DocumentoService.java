package com.senac.cl.service;

import com.senac.cl.modelos.Livro;

public class DocumentoService {

	public Livro visualizaDocumento(Livro documentoED) {
	    documentoED.setArquivo(documentoED.getArquivo());
		return documentoED;
	}
}
