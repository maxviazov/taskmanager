package com.nishapro.entity.types;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PriorityConverter implements AttributeConverter<Priority, String> {
    @Override
    public String convertToDatabaseColumn(Priority priority) {
        if (priority == null){
            return null;
        }
        return priority.name();
    }

    @Override
    public Priority convertToEntityAttribute(String dbName) {
        if (dbName == null){
            return null;
        }
        return Priority.valueOf(dbName);
    }
}
