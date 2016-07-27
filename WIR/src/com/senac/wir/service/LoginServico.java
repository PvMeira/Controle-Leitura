package com.senac.wir.service;

import java.util.List;

import javax.inject.Inject;

import com.senac.wir.domain.Login;
import com.senac.wir.repository.LoginRepositorio;
import com.senac.wir.transactional.Transacional;

public class LoginServico {
	@Inject
	private LoginRepositorio repositorio;

	@Transacional
	public void salvar(Login login) {
		if (login.getIdLogin() == null ) {
			repositorio.inserir(login);
		} else {
			repositorio.atualizar(login);
		}
	}

	@Transacional
	public List<Login> carregaTodosLoginsDoBanco() {
		return repositorio.todosLogins();
	}

	@Transacional
	public void deletar(Login login) {
		repositorio.remover(login);
		;
	}
}
