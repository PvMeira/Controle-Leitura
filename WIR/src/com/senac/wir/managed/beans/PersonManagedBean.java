package com.senac.wir.managed.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.senac.wir.domain.Person;
import com.senac.wir.service.PersonService;
import com.senac.wir.util.MessengerSystem;

@ManagedBean
@ViewScoped
public class PersonManagedBean {

	private Person person;
	private List<Person> listOfRegisterPersons;

	@Inject
	private PersonService service;

	public PersonManagedBean() {
	}

	public void save() {
		service.save(getPerson());
		MessengerSystem.notifyInformation("Parabéns!", "Cadastro salvo com sucesso!");
		loadListOfPersons();
		clean();
	}

	public void delete(Person person) {
		service.delete(person);
		MessengerSystem.notifyInformation("Parabéns!", "Cadastro deletado com sucesso!");
		loadListOfPersons();
		clean();
	}

	public void clean() {
		setPerson(new Person());
	}

	private void loadListOfPersons() {
		setListOfRegisterPersons(service.loadPersonsFromDataBase());
	}

	public List<Person> getListOfRegisterPersons() {
		if (listOfRegisterPersons == null) {
			loadListOfPersons();
		}
		return listOfRegisterPersons;
	}

	public void setListOfRegisterPersons(List<Person> listOfRegisterPersons) {
		this.listOfRegisterPersons = listOfRegisterPersons;
	}

	public Person getPerson() {
		if (person == null) {
			clean();
		}
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}