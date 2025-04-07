package domainstructure.domainstructure.infrastructure.common.converter;

import domainstructure.domainstructure.core.common.vo.Email;
import jakarta.persistence.AttributeConverter;

public class EmailConverter implements AttributeConverter<Email, String> {
    @Override
    public String convertToDatabaseColumn(Email attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public Email convertToEntityAttribute(String dbData) {
        return dbData == null ? null : Email.of(dbData);
    }

}
