package com.senac.cl.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.senac.cl.modelos.Resenha;
/**
 * 
 * @author Pedro
 * @since 13/09/2016
 */
@SuppressWarnings(value = "all")
public class ResenhaRepository {

	@Inject
	private EntityManager entityManager;

	/**
	 * Inseri entidade
	 * 
	 * @param ed
	 */
	public void inserir(Resenha ed) {
		entityManager.persist(ed);
	}

	public void remover(Resenha ed) {
		entityManager.remove(entityManager.merge(ed));
	}

	/**
	 * Remove entidade pelo seu Id do banco
	 * 
	 * @param id
	 */
	public void removerPeloId(Integer id) {
		Resenha entity = entityManager.find(Resenha.class, id);
		entityManager.remove(entity);
	}

	/**
	 * Atualiza entidade
	 * 
	 * @param pessoa
	 */
	public void atualizar(Resenha ed) {
		entityManager.merge(ed);
	}

	/**
	 * Busca Entidade pelo seu ID do banco
	 * 
	 * @param id
	 * @return
	 */
	public Resenha buscarPeloId(Long id) {
		return entityManager.find(Resenha.class, id);
	}
	/**
	 * Retirna Lista de resenha acabadas pelo id do usuario passado
	 * @param id
	 * @return
	 */
	public List<Resenha> listaResenhasAcabadasUsuario(Long id){
			String sql = "SELECT * FROM resenha where inacabada = false and id_pessoa = "+id+";";
			List<Resenha> lista = entityManager.createNativeQuery(sql, Resenha.class).getResultList();
		return lista;
	}
	/**
	 * Retirna lista de resenhas inacabadas pelo id do usuario
	 * @param id
	 * @return
	 */
	public List<Resenha> listaResenhasInacabadasUsuario(Long id){
		String sql = "SELECT * FROM resenha where inacabada = true and id_pessoa = "+id+";";
		List<Resenha> lista = entityManager.createNativeQuery(sql, Resenha.class).getResultList();
	return lista;
}


}
