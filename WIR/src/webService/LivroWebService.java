package webService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.senac.cl.modelos.Livro;

import webService.modelos.LivroWS;
import webService.servicos.LivroWSService;

@Path("/livros")
public class LivroWebService {

	@Inject
	private LivroWSService livroServico;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<LivroWS> listAll() {
		List<LivroWS> listaRetorno = new ArrayList<LivroWS>();
		List<Livro> listLivro = new ArrayList<Livro>();

		listLivro = livroServico.listarTodosRegistros();
		for (Livro livro : listLivro) {
			LivroWS l = this.montaEntidadeWS(livro);
			listaRetorno.add(l);
		}
		return listaRetorno;
	}

	private LivroWS montaEntidadeWS(Livro l) {
		LivroWS ed = new LivroWS();
		ed.setAutor(l.getAutor());
		ed.setIdLivro(l.getIdLivro());
		ed.setPaginas(l.getPaginas());
		ed.setTitulo(l.getTitulo());
		ed.setLivroAtivo(l.isLivroAtivo());

		return ed;
	}

}
