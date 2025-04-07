package domainstructure.domainstructure.infrastructure.user.converter;

import domainstructure.domainstructure.core.user.vo.Nickname;
import jakarta.persistence.AttributeConverter;

public class NicknameConverter implements AttributeConverter<Nickname, String> {
    @Override
    public String convertToDatabaseColumn(Nickname attribute) {
        return attribute != null ? attribute.toString() : null;
    }

    @Override
    public Nickname convertToEntityAttribute(String dbData) {
        return dbData != null ? Nickname.of(dbData) : null;
    }

}
