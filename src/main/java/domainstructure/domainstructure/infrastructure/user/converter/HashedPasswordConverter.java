package domainstructure.domainstructure.infrastructure.user.converter;

import domainstructure.domainstructure.core.user.vo.HashedPassword;
import jakarta.persistence.AttributeConverter;

public class HashedPasswordConverter implements AttributeConverter<HashedPassword, String> {
    @Override
    public String convertToDatabaseColumn(HashedPassword attribute) {
        return attribute == null ? null : attribute.getValue();
    }

    @Override
    public HashedPassword convertToEntityAttribute(String dbData) {
        return dbData == null ? null : HashedPassword.of(dbData);
    }

}
