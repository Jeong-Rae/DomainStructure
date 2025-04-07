package domainstructure.domainstructure.infrastructure.user.mapper;

import domainstructure.domainstructure.core.user.model.Address;
import domainstructure.domainstructure.infrastructure.user.entity.AddressEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AddressMapper {

    public static AddressEntity toEntity(Address address) {
        if (address == null) {
            return null;
        }
        return AddressEntity.of(
                address.getId(),
                address.getCity(),
                address.getStreet(),
                address.getZipcode()
        );
    }

    public static Address toDomain(AddressEntity entity) {
        if (entity == null) {
            return null;
        }
        return Address.of(
                entity.getId(),
                entity.getCity(),
                entity.getStreet(),
                entity.getZipcode()
        );
    }
}