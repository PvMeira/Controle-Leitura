package com.senac.cl.conversores;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.faces.convert.FacesConverter;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
/**
 * 
 * @author Pedro
 * @since 27/agosto
 */
@Converter(autoApply = true)
@FacesConverter("time")
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {
/**
 * Metodo para converter LocalDate para TimeStamp- geralmente data que é recebida do Banco
 * @param LocalDateTime
 * @return TimeStamp
 */
	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
		return (locDateTime == null ? null : Timestamp.valueOf(locDateTime));
	}
/**
 * Metodo para converter Timestamp para LodalDate - geralmente data do sistema para o banco
 * @param TimeStamp
 * @return LocalDateTime
 */
	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
		return (sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime());
	}
}