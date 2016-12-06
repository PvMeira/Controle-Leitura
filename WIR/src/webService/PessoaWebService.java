package webService;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.senac.cl.modelos.Pessoa;
import com.senac.cl.utilitarios.Data;

import webService.modelos.PessoaWS;
import webService.servicos.UtilizadoresWSService;

@Path("/user")
public class PessoaWebService {

	@Inject
	private UtilizadoresWSService service;

	Data dataUtil;

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
			p.setPassword(ed.getPassword());
			p.setDataUltimoLogin(format(ed.getDataUltimoLogin()));
			listaFinal.add(p);
		}
		return listaFinal;
	}

	private String format(Calendar c) {
		Date data = c.getTime();
		DateFormat dataFormatada = DateFormat.getDateInstance(DateFormat.LONG);
		String dataFinalFormatada = " ".concat(dataFormatada.format(data));

		return dataFinalFormatada;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/add")
	public PessoaWS create(PessoaWS ed) {
		Pessoa p = new Pessoa();
		p.setCpf(ed.getCpf());
		p.setNome(ed.getNome());
		p.setMail(ed.getMail());
		p.setTelefone(ed.getTelefone());
		p.setUsername(ed.getUsername());
		p.setPassword(ed.getPassword());
		p.setDataLoginAtual(Calendar.getInstance());
		p.setDataUltimoLogin(Calendar.getInstance());
		p.setFotoUser(null);
		p.setAdm(false);
		p.setNormal(true);
		p.setLivros(null);
		p.setLogado(false);
		this.service.salvar(p);
		return ed;
	}

	@POST
	@Path("/delete/{idPessoa}")
	public void delete( @PathParam("idPessoa") int id) {
		this.service.remover(id);
	}

}
