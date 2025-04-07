package domainstructure.domainstructure.infrastructure.user.mapper;

import domainstructure.domainstructure.core.user.model.User;
import domainstructure.domainstructure.infrastructure.user.embeddable.AccountEmbeddable;
import domainstructure.domainstructure.infrastructure.user.entity.AddressEntity;
import domainstructure.domainstructure.infrastructure.user.entity.ProfileEntity;
import domainstructure.domainstructure.infrastructure.user.entity.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    public static UserEntity toEntity(User user) {
        if (user == null) {
            return null;
        }

        AccountEmbeddable accountEmbeddable = AccountMapper.toEmbeddable(user.getAccount());
        ProfileEntity profileEntity = ProfileMapper.toEntity(user.getProfile());
        AddressEntity addressEntity = AddressMapper.toEntity(user.getAddress());

        return UserEntity.of(user.getId(), accountEmbeddable, profileEntity, addressEntity);
    }

    public static User toDomain(UserEntity entity) {
        if (entity == null) {
            return null;
        }

        return User.of(entity.getId(),
                       AccountMapper.toDomain(entity.getAccount()),
                       ProfileMapper.toDomain(entity.getProfile()),
                       AddressMapper.toDomain(entity.getAddress()));
    }
}
