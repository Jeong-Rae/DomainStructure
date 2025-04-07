package domainstructure.domainstructure.application.user.service;

import domainstructure.domainstructure.core.common.vo.Email;
import domainstructure.domainstructure.core.user.repository.UserRepository;
import domainstructure.domainstructure.core.user.service.UserRegistrationPolicy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserRegistrationPolicyImpl implements UserRegistrationPolicy {
    private final UserRepository userRepository;

    @Override
    public boolean isEmailDuplicated(Email email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean isPasswordWeak(String rawPassword) {
        return rawPassword != null && rawPassword.length() < 8 && !rawPassword.matches(".*\\d.*");
    }
}
