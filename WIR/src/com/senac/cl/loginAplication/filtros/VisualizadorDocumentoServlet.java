package com.senac.cl.loginAplication.filtros;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.senac.cl.managed.beans.VisualizacaoMB;

@WebServlet(value = "/visualizarDocumento.xhtml", name = "visualizarDocumentoServlet")
public class VisualizadorDocumentoServlet extends HttpServlet {

	@Inject
	VisualizacaoMB visualizadorDocumentoMB;

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		byte[] content = visualizadorDocumentoMB.getBytesLivro();
		if (content == null) {
			return;
		}
		response.setContentType("charset=UTF-8");
		response.setContentLength(content.length);
		response.getOutputStream().write(content);
	}
}
