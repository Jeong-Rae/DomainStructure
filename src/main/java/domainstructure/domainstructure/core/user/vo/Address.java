package domainstructure.domainstructure.core.user.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class Address {
    private final String city;
    private final String street;
    private final String zipcode;

    private Address(String city, String street, String zipcode) {
        validate(city, street, zipcode);
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public static Address of(final String city, final String street, final String zipcode) {
        return Address.builder().city(city).street(street).zipcode(zipcode).build();
    }

    private void validate(String city, String street, String zipcode) {
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("city must not be null or blank");
        }
        if (street == null || street.isBlank()) {
            throw new IllegalArgumentException("street must not be null or blank");
        }
        if (zipcode == null || zipcode.isBlank()) {
            throw new IllegalArgumentException("zipcode must not be null or blank");
        }
    }
}
