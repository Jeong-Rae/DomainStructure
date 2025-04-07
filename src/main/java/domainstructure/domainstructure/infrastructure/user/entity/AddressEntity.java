package domainstructure.domainstructure.infrastructure.user.entity;


import domainstructure.domainstructure.core.user.vo.City;
import domainstructure.domainstructure.infrastructure.user.converter.CityConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    @Convert(converter = CityConverter.class)
    private City city;

    @Column(name = "street")
    private String street;

    @Column(name = "zipcode")
    private String zipcode;

    private AddressEntity(Long id, City city, String street, String zipcode) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public static AddressEntity of(Long id, City city, String street, String zipcode) {
        return new AddressEntity(id, city, street, zipcode);
    }
}
