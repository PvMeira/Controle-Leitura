package webService;


import java.util.List;

import javax.inject.Inject;

import com.senac.cl.modelos.Livro;
import com.senac.cl.repository.LivroRepository;
import com.senac.cl.transactional.Transactional;
/**
 * @author Pedro
 * @since 25/09/2016
 */
public class LivroWSService {

	@Inject
	LivroRepository livroRepository;

	/**
	 * 
	 * @return
	 */
	@Transactional
	public List<Livro> listarTodosRegistros() {
		return livroRepository.todosOsRegistros();
	}
}
