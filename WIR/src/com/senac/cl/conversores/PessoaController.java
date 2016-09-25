package com.senac.cl.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.senac.cl.modelos.Pessoa;
import com.senac.cl.repository.PessoaRepository;

@FacesConverter(forClass = Pessoa.class)
public class PessoaController implements Converter {

	@Inject
	PessoaRepository livroRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String string) {
		if (string == null || string.isEmpty()) {
			return null;
		}
		return livroRepository.buscarPeloId(Long.valueOf(string));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		Pessoa produto = (Pessoa) object;
		if (produto == null || produto.getIdPessoa() == null) {
			return null;
		}
		return String.valueOf(produto.getIdPessoa());
	}
}