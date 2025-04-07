package domainstructure.domainstructure.core.user.service;

import domainstructure.domainstructure.core.user.vo.HashedPassword;

public interface PasswordEncryptor {
    HashedPassword encode(String rawPassword);

    boolean matched(String rawPassword, HashedPassword hashedPassword);
}
