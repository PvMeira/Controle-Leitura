package com.senac.cl.conversores;

import java.text.NumberFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
/**
 * 
 *  @author Pedro
 *	@since 27/agosto
 */
@FacesConverter(value = "ConversorMoedaReal")
public class ConversorMoeda implements Converter {
	/**
	 * Conversor de moeda Para 1camada Recebe uma string e devolve um objeto
	 * 
	 * @param FacesContext
	 * @param UIComponent
	 * @param String
	 * @return Double salario
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent uiComponent, String salary) {
		return Double.parseDouble(salary);
	}
	/**
	 * Conversor de moeda Para 1camada Recebe uma objeto e devolve uma string
	 * 
	 * @param FacesContext
	 * @param UIComponent
	 * @param Object
	 * @return String salario formatado
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent uiComponent, Object formatedSalary) {
		Double salary = (Double) formatedSalary;
		return NumberFormat.getCurrencyInstance().format(salary);
	}
}