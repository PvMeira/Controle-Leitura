package com.senac.cl.validadores;


import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.senac.cl.utilitarios.SistemaDeMensagens;;
/**
 * 
 * @author Pedro
 * @since 27/08/2016
 */
@FacesValidator(value = "cpfValidator")
public class ValidadorParaCpf implements Validator {

    private Integer firstDigit, secondDigit;
/**
 * Validao o numero de caracteres do CPF < ou > 11
 */
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (value != null) {
            String cpf = value.toString();
            if (cpf.length() < 11) {
                cpf = String.format("%011d", Long.parseLong(value.toString()));
            }
            if (isAPatternCpf(cpf) || !validateCpf(cpf)) {
                ((UIInput) component).setValid(false);
                SistemaDeMensagens.notificaERRO("CPF invalido","numero ou caracteres invalidos");
            }
        }
    }
/**
 * Verifica se Tem a patern de CPF
 * @param cpf
 * @return
 */
    private static boolean isAPatternCpf(String cpf) {
        return cpf.matches("\\b(\\d)\\1+\\b");
    }
/**
 * Calculo para a validação do CPF
 * @param cpf
 * @return
 */
    private boolean validateCpf(String cpf) {
        firstDigit = calculateCheckerOfDigit(10, cpf.substring(0, 9));
        secondDigit = calculateCheckerOfDigit(11, cpf.substring(0, 9).concat(firstDigit.toString()));

        return (firstDigit.toString().concat(secondDigit.toString())).equals(cpf.substring(9, 11));
    }
/**
 * checa o calculo do digito
 * @param multiplicador
 * @param cpf
 * @return
 */
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