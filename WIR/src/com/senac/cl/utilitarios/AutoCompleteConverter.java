package com.senac.cl.utilitarios;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.senac.cl.modelos.Livro;

@FacesConverter("livroConverter")
public class AutoCompleteConverter implements Converter {

	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				Livro service = (Livro) fc.getExternalContext().getApplicationMap().get("livroSelecionado");
				return service;
			} catch (NumberFormatException e) {
				throw new ConverterException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid Book."));
			}
		} else {
			return null;
		}
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			fc.getExternalContext().getApplicationMap().put("livroSelecionado", object);
			return String.valueOf(((Livro) object).getIdLivro());
		} else {
			return null;
		}
	}
}
