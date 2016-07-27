package com.senac.wir.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.senac.wir.domain.Person;

@SuppressWarnings("all")
public class PersonRepository {

	@Inject
	private EntityManager entityManager;

	public void insert(Person person) {
		entityManager.persist(person);
	}

	public List<Person> allPerson() {
		return entityManager.createQuery("select l from " + Person.class.getSimpleName() + " l").getResultList();
	}

	public void remove(Person person) {
		entityManager.remove(entityManager.merge(person));
	}

	public void removeById(Integer id) {
		Person entity = entityManager.find(Person.class, id);
		entityManager.remove(entity);
	}

	public void update(Person person) {
		entityManager.merge(person);
	}

	public Person searchById(Integer id) {
		return entityManager.find(Person.class, id);
	}

}