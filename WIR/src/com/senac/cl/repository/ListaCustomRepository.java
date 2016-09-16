package com.senac.cl.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.senac.cl.modelos.ListaCustom;

/**
 * 
 * @author Pedro
 * @since 13/09/2016
 */
public class ListaCustomRepository {
	@Inject
	protected EntityManager entityManager;

	public void inserir(ListaCustom d) {
		entityManager.persist(d);

	}

	public void deletar(ListaCustom ed) {
		entityManager.remove(entityManager.merge(ed));

	}

	public void atualizar(ListaCustom livro) {
		entityManager.merge(livro);

	}

	@SuppressWarnings(value = { "all" })
	public List<ListaCustom> todosOsRegistros() {
		return entityManager.createQuery("select l from " + ListaCustom.class.getSimpleName() + " l").getResultList();
	}
	
	public List<ListaCustom>listaRegistrosPessoaLogada(Long id){
		String sql ="SELECT * FROM lista_cust where id_pessoa = "+id+";";
		List<ListaCustom> lista =  entityManager.createNativeQuery(sql).getResultList();
		return lista;
	}

}
