package webService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.senac.cl.modelos.Pessoa;

import webService.modelos.PessoaWS;
import webService.servicos.UtilizadoresWSService;

@Path("/user")
public class PessoaWebService {

	@Inject
	private UtilizadoresWSService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<PessoaWS> listarRegistros() {
		List<Pessoa> list = service.listarTodos();
		List<PessoaWS> listaFinal = new ArrayList<>();
		for (Pessoa ed : list) {
			PessoaWS p = new PessoaWS();
			p.setIdPessoa(ed.getIdPessoa());
			p.setCpf(ed.getCpf());
			p.setMail(ed.getMail());
			p.setNome(ed.getNome());
			p.setTelefone(ed.getTelefone());
			p.setUsername(ed.getUsername());
			listaFinal.add(p);
		}
		return listaFinal;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/find/{id}")
	public PessoaWS findOne(@PathParam("id") Integer id) {
		Pessoa ed = service.buscarPeloId(id.longValue());
		PessoaWS p = new PessoaWS();
		p.setIdPessoa(ed.getIdPessoa());
		p.setCpf(ed.getCpf());
		p.setMail(ed.getMail());
		p.setNome(ed.getNome());
		p.setTelefone(ed.getTelefone());
		p.setUsername(ed.getUsername());
		return p;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/add")
	public Pessoa create(Pessoa ed) {
		Pessoa p = new Pessoa();
		p.setCpf(ed.getCpf());
		p.setNome(ed.getNome());
		p.setMail(ed.getMail());
		p.setTelefone(ed.getTelefone());
		p.setUsername(ed.getUsername());
		p.setDataLoginAtual(Calendar.getInstance());
		p.setDataUltimoLogin(Calendar.getInstance());
		p.setFotoUser(null);
		p.setAdm(false);
		p.setNormal(true);
		this.service.salvar(p);
		return p;
	}

}
