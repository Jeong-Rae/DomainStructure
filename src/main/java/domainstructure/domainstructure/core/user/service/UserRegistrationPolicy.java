package domainstructure.domainstructure.core.user.service;

import domainstructure.domainstructure.core.common.vo.Email;

public interface UserRegistrationPolicy {
    boolean isEmailDuplicated(Email email);

    boolean isPasswordWeak(String rawPassword);
}
