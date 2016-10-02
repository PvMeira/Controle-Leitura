package com.senac.cl.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.senac.cl.modelos.Livro;
import com.senac.cl.repository.LivroRepository;

@Path("/livros")
public class LivroWebService {

	@Inject
	LivroRepository livroRepository;

	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Livro> listarlivros() {
		List<Livro> lista = null;

		try {
			lista = this.livroRepository.todosOsRegistros();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
