package domainstructure.domainstructure.core.user.vo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class Address {
    private final City city;
    private final String street; // TODO: VO로 변경해야함 @Lyght.Kim
    private final String zipcode; // TODO: VO로 변경해야함 @Lyght.Kim

    private Address(City city, String street, String zipcode) {
        validate(city, street, zipcode);
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public static Address of(final City city, final String street, final String zipcode) {
        return Address.builder()
                      .city(city)
                      .street(street)
                      .zipcode(zipcode)
                      .build();
    }

    private void validate(City city, String street, String zipcode) {
        if (city == null) {
            throw new IllegalArgumentException("city must not be null");
        }
        if (street == null || street.isBlank()) {
            throw new IllegalArgumentException("street must not be null or blank");
        }
        if (zipcode == null || zipcode.isBlank()) {
            throw new IllegalArgumentException("zipcode must not be null or blank");
        }
    }
}
