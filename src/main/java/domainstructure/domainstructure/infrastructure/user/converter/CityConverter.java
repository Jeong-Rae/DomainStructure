package domainstructure.domainstructure.infrastructure.user.converter;

import domainstructure.domainstructure.core.user.vo.City;
import jakarta.persistence.AttributeConverter;

public class CityConverter implements AttributeConverter<City, String> {
    @Override
    public String convertToDatabaseColumn(City attribute) {
        return attribute != null ? attribute.toString() : null;
    }

    @Override
    public City convertToEntityAttribute(String dbData) {
        return dbData != null ? City.from(dbData) : null;
    }
}
