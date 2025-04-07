package domainstructure.domainstructure.core.user.support;

import domainstructure.domainstructure.core.user.vo.UserID;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class UserIDGenerator {
    public static UserID generate() {
        return UserID.of(UUID.randomUUID().toString());
    }

}
