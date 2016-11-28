package webService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.senac.cl.modelos.Livro;

@Path("/livros")
@Produces({ "application/json" })
public class LivroWebService {

	@Inject
	private LivroWSService livroServico;

	@GET
	@Path("/")
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

	private LivroWS montaEntidadeWS(Livro livro) {
		LivroWS livroWS = new LivroWS();
		livroWS.setIdLivro(livro.getIdLivro().intValue());
		livroWS.setNomeAutor(livro.getAutor());
		livroWS.setNomeDono(livro.getDono().getNome());
		livroWS.setNomeLivro(livro.getTitulo());
		livroWS.setPaginas(livro.getPaginas());
		livroWS.setPontuacao(livro.getPontuacao());
		return livroWS;
	}

	// @GET
	// @Path("/{id}")
	// public Livro umLivro(@PathParam("id") Integer id) {
	// return livroServico.
	// }
}
