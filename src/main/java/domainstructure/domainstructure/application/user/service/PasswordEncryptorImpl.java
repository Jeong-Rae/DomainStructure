package domainstructure.domainstructure.application.user.service;

import domainstructure.domainstructure.core.user.service.PasswordEncryptor;
import domainstructure.domainstructure.core.user.vo.HashedPassword;
import domainstructure.domainstructure.infrastructure.security.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PasswordEncryptorImpl implements PasswordEncryptor {
    private final PasswordEncoder passwordEncoder;

    @Override
    public HashedPassword encode(String rawPassword) {
        return HashedPassword.of(passwordEncoder.encode(rawPassword));
    }

    @Override
    public boolean matched(String rawPassword, HashedPassword hashedPassword) {
        return passwordEncoder.matches(rawPassword, hashedPassword.getValue());
    }
}
