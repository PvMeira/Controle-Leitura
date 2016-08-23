package com.senac.wir.service;

import java.util.List;

import javax.inject.Inject;

import com.senac.wir.domain.Person;
import com.senac.wir.repository.PersonRepository;
import com.senac.wir.transactional.Transactional;

public class PersonService {

	@Inject
	private PersonRepository repository;

	@Transactional
	public void save(Person person) {
		if (person.getId() == null) {
			repository.insert(person);
		} else {
			repository.update(person);
		}
	}

	@Transactional
	public List<Person> loadPersonsFromDataBase() {
		return repository.allPerson();
	}

	@Transactional
	public void delete(Person person) {
		repository.remove(person);
		;
	}

}
