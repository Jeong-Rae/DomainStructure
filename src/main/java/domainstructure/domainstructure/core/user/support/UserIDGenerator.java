package domainstructure.domainstructure.core.user.support;

import domainstructure.domainstructure.core.user.vo.UserID;

import java.util.UUID;

public class UserIDGenerator {
    private UserIDGenerator() {
    }

    public static UserID generate() {
        return UserID.of(UUID.randomUUID().toString());
    }

}
