package com.senac.cl.validadores;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * @author Pedro
 * @since 25/09/2016
 */
@FacesValidator(value = "cpfValidator")
public class ValidadorParaCpf implements Validator {

	private Integer firstDigit, secondDigit;

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (value != null) {
			String cpf = value.toString();
			if (cpf.length() < 11) {
				cpf = String.format("%011d", Long.parseLong(value.toString()));
			}
			if (isAPatternCpf(cpf) || !validateCpf(cpf)) {
				((UIInput) component).setValid(false);
				throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de valida��o",
						cpf + " n�o � um CPF v�lido;"));
			}
		}
	}

	private static boolean isAPatternCpf(String cpf) {
		return cpf.matches("\\b(\\d)\\1+\\b");
	}

	private boolean validateCpf(String cpf) {
		firstDigit = calculateCheckerOfDigit(10, cpf.substring(0, 9));
		secondDigit = calculateCheckerOfDigit(11, cpf.substring(0, 9).concat(firstDigit.toString()));

		return (firstDigit.toString().concat(secondDigit.toString())).equals(cpf.substring(9, 11));
	}

	private static Integer calculateCheckerOfDigit(int multiplicador, String cpf) {
		Integer digit;
		int soma = 0;
		for (int i = 0; i < cpf.length(); i++) {
			soma += (Integer.parseInt(cpf.substring(i, i + 1)) * multiplicador);
			multiplicador -= 1;
		}

		if (soma % 11 < 2) {
			digit = 0;
		} else {
			digit = new Integer(11 - (soma % 11));
		}
		return digit;
	}

}