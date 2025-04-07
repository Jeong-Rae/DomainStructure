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
    public boolean canRegisterWith(Email email) {
        return !isDuplicate(email);
    }

    private boolean isDuplicate(Email email) {
        return userRepository.existsByEmail(email);
    }
}
