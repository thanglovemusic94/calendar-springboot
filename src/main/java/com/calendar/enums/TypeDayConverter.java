package com.calendar.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TypeDayConverter implements AttributeConverter<TypeDay, String> {
 
    @Override
    public String convertToDatabaseColumn(TypeDay typeDay) {
        return typeDay.getTypeDay();
    }
 
    @Override
    public TypeDay convertToEntityAttribute(String typeDay) {
        return TypeDay.fromTypeDay(typeDay);
    }
}
