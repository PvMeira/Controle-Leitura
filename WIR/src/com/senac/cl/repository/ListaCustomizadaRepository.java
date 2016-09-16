package com.senac.cl.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.senac.cl.modelos.ListaCustomizada;

/**
 * 
 * @author Pedro
 * @since 13/09/2016
 */
public class ListaCustomizadaRepository {
	@Inject
	protected EntityManager entityManager;

	public void inserir(ListaCustomizada d) {
		entityManager.persist(d);

	}

	public void deletar(ListaCustomizada ed) {
		entityManager.remove(entityManager.merge(ed));

	}

	public void atualizar(ListaCustomizada livro) {
		entityManager.merge(livro);

	}

	@SuppressWarnings(value = { "all" })
	public List<ListaCustomizada> todosOsRegistros() {
		return entityManager.createQuery("select l from " + ListaCustomizada.class.getSimpleName() + " l").getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<ListaCustomizada>listaRegistrosPessoaLogada(Long id){
		String sql ="SELECT * FROM lista_customizada where id_pessoa = "+id+";";
		List<ListaCustomizada> lista =  entityManager.createNativeQuery(sql,ListaCustomizada.class).getResultList();
		return lista;
	}

}
