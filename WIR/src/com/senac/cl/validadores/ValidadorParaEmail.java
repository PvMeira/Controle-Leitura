package com.senac.cl.validadores;

import javax.faces.validator.FacesValidator;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
/**
 * @author Pedro
 * @since 25/09/2016
 */
@FacesValidator("emailValidator")
public class ValidadorParaEmail implements Validator {

	private Pattern pattern;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public ValidadorParaEmail() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (value == null) {
			return;
		}

		if (!pattern.matcher(value.toString()).matches()) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de validação",
					value + " não é um email válido;"));
		}
	}

}