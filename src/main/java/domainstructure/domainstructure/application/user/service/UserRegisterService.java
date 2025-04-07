package domainstructure.domainstructure.application.user.service;

import domainstructure.domainstructure.application.exception.ApplicationException;
import domainstructure.domainstructure.application.exception.ErrorCode;
import domainstructure.domainstructure.application.user.assembler.UserRegisterAssembler;
import domainstructure.domainstructure.application.user.dto.UserRegisterRequest;
import domainstructure.domainstructure.core.user.model.User;
import domainstructure.domainstructure.core.user.repository.UserRepository;
import domainstructure.domainstructure.core.user.service.PasswordEncryptor;
import domainstructure.domainstructure.core.user.service.UserRegistrationPolicy;
import domainstructure.domainstructure.core.user.vo.HashedPassword;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserRegisterService {
    private final PasswordEncryptor passwordEncryptor;
    private final UserRegistrationPolicy userRegistrationPolicy;
    private final UserRepository userRepository;

    @Transactional
    public User register(UserRegisterRequest request) {
        validatePolicy(request);

        HashedPassword hashedPassword = passwordEncryptor.encode(request.password());
        User newUser = UserRegisterAssembler.toUser(request, hashedPassword);
        return userRepository.save(newUser);
    }

    private void validatePolicy(UserRegisterRequest request) {
        if (userRegistrationPolicy.isEmailDuplicated(request.email())) {
            throw new ApplicationException(ErrorCode.DUPLICATED_EMAIL, request.email().toString());
        }

        if (userRegistrationPolicy.isPasswordWeak(request.password())) {
            throw new ApplicationException(ErrorCode.WEAK_PASSWORD, request.password());
        }
    }
}
