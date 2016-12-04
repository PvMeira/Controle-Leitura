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

	@Transactional
	public Pessoa buscarPeloId(long id) {
		return this.pessoaRepository.buscarPeloId(id);
	}
	public void salvar(Pessoa ed) {
		this.pessoaRepository.inserir(ed);
	}
}