package webService.servicos;

import java.util.List;

import javax.inject.Inject;

import com.senac.cl.modelos.Pessoa;
import com.senac.cl.repository.LivroRepository;
import com.senac.cl.repository.PessoaRepository;
import com.senac.cl.transactional.Transactional;

public class UtilizadoresWSService {

	@Inject
	PessoaRepository pessoaRepository;

	@Inject
	LivroRepository livroRepository;

	@Transactional
	public List<Pessoa> listarTodos() {
		return this.pessoaRepository.todasAsPessoas();
	}

	@Transactional
	public int contarLivrosUsuarios(long id) {
		return this.livroRepository.todosOsRegistrosDoUsuario(id).size();
	}

}
