package domainstructure.domainstructure.infrastructure.user.mapper;

import domainstructure.domainstructure.core.user.model.Profile;
import domainstructure.domainstructure.infrastructure.user.entity.ProfileEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ProfileMapper {
    public static ProfileEntity toEntity(Profile profile) {
        if (profile == null) {
            return null;
        }
        return ProfileEntity.of(
                profile.getId(),
                profile.getNickname(),
                profile.getBirthday()
        );
    }

    public static Profile toDomain(ProfileEntity entity) {
        if (entity == null) {
            return null;
        }
        return Profile.of(
                entity.getId(),
                entity.getNickname(),
                entity.getBirthday()
        );
    }
}