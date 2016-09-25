package com.senac.cl.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.senac.cl.modelos.Livro;
import com.senac.cl.repository.LivroRepository;

@FacesConverter(forClass=Livro.class)
public class LivroController implements Converter {

	
@Inject
LivroRepository livroRepository;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String string) {
		System.out.println("ProdutoConverter.getAsObject(): " + string);
		if(string == null || string.isEmpty()){
			return null;
		}
		return livroRepository.search(Long.valueOf(string));
	}
 
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		Livro produto = (Livro) object;
		System.out.println("ProdutoConverter.getAsString(): " + produto);
		if(produto == null || produto.getIdLivro() == null){
			return null;
		}
		return String.valueOf(produto.getIdLivro());
	}
}