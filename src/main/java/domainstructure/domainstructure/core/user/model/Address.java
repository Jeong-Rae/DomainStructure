package domainstructure.domainstructure.core.user.model;

import domainstructure.domainstructure.core.user.vo.City;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {
    @EqualsAndHashCode.Include
    private final Long id;
    private final City city;
    private final String street; // TODO: VO로 변경해야함 @Lyght.Kim
    private final String zipcode; // TODO: VO로 변경해야함 @Lyght.Kim

    @Builder(toBuilder = true)
    private Address(Long id, City city, String street, String zipcode) {
        validate(city, street, zipcode);
        this.id = id;
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

    public static Address of(final long id, final City city, final String street, final String zipcode) {
        return Address.builder()
                      .id(id)
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
