package webService;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.senac.cl.modelos.Livro;
import com.senac.cl.service.LivroService;

@Path("/livros")
@Produces({ "application/json" })
public class LivroWebService {

	@Inject
	private LivroWSService livroServico;
	
	@GET
	@Path("/")
	public List<Livro> listAll() {
		return livroServico.listarTodosRegistros();
	}

//	@GET
//	@Path("/{id}")
//	public Livro umLivro(@PathParam("id") Integer id) {
//		return livroServico.
//}	
}
