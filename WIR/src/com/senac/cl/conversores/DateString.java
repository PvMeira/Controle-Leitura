
package com.senac.cl.conversores;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * 
 * @author Pedro
 *@since 27/agosto
 */

@FacesConverter(value="localDate")
public class DateString implements Converter {
	/**
	 * Conversor de Data Para 1camada e BD Recebe uma string e devolve um LocalDate
	 * 
	 * @param FacesContext
	 * @param UIComponent
	 * @param String
	 * @return LocalDate dataString
	 */
 @Override
 public Object getAsObject(FacesContext arg0, UIComponent arg1, String dataString) {
  return LocalDateTime.parse(dataString);
 }
	/**
	 * Conversor de Data Para 1camada  Recebe um objeto e devolve uma string formatada
	 * 
	 * @param FacesContext
	 * @param UIComponent
	 * @param Object
	 * @return String dataString.format
	 */
 @Override
 public String getAsString(FacesContext arg0, UIComponent arg1, Object localDateUnformated) {
  LocalDateTime Date = (LocalDateTime) localDateUnformated;
  return Date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
 }
}