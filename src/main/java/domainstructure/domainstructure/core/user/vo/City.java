package domainstructure.domainstructure.core.user.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import domainstructure.domainstructure.core.user.type.CityType;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class City {
    private final CityType value;

    private City(CityType value) {
        validate(value);
        this.value = value;
    }

    @JsonCreator
    public static City from(String name) {
        return new City(CityType.from(name));
    }

    public static City of(CityType cityType) {
        return new City(cityType);
    }

    private void validate(CityType value) {
        if (value == null) {
            throw new IllegalArgumentException("city must not be null");
        }
    }

    @JsonValue
    @Override
    public String toString() {
        return value.toString();
    }
}
