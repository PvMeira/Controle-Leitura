package webService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.senac.cl.modelos.Livro;
import com.senac.cl.modelos.Pessoa;

import webService.modelos.LivroWS;
import webService.modelos.UtilizadoresWS;
import webService.servicos.UtilizadoresWSService;

@Path("/user")
@Produces({ "application/json" })
public class UtilizadoresWebService {

	@Inject
	private UtilizadoresWSService service;

	@GET
	@Path("/")
	public List<UtilizadoresWS> listAll() {
		List<UtilizadoresWS> listaRetorno = new ArrayList<UtilizadoresWS>();
		List<Pessoa> listPessoa = new ArrayList<Pessoa>();

		listPessoa = service.listarTodos();

		for (Pessoa pessoa : listPessoa) {
			UtilizadoresWS l = this.montaEntidadeWS(pessoa);
			listaRetorno.add(l);
		}
		return listaRetorno;
	}

	private UtilizadoresWS montaEntidadeWS(Pessoa pessoa) {
		UtilizadoresWS entity = new UtilizadoresWS();
		Long id = pessoa.getIdPessoa();

		entity.setId(id.intValue());
		entity.setNome(pessoa.getNome());
		entity.setData(this.montaCalendario(pessoa.getDataUltimoLogin()));
		entity.setLivrosCompartilhados(this.buscaNumerolivrosCompartilhados(id));

		return entity;
	}

	private int buscaNumerolivrosCompartilhados(final Long id) {
		int retorno = 0;
		retorno = this.service.contarLivrosUsuarios(id);
		return retorno;
	}

	private String montaCalendario(Calendar cal) {
		String calendarioString = null;
		StringBuilder sb = new StringBuilder();
		sb.append(cal.getTime().getDay());
		sb.append("/");
		sb.append(cal.getTime().getMonth());
		sb.append("/");
		sb.append("2016");

		calendarioString = sb.toString();

		return calendarioString;
	}
}
