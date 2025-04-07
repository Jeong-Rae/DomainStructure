package domainstructure.domainstructure.application.user.service;

import domainstructure.domainstructure.application.exception.ApplicationException;
import domainstructure.domainstructure.application.user.dto.UserRegisterRequest;
import domainstructure.domainstructure.core.common.vo.Email;
import domainstructure.domainstructure.core.user.model.Address;
import domainstructure.domainstructure.core.user.model.Profile;
import domainstructure.domainstructure.core.user.model.User;
import domainstructure.domainstructure.core.user.repository.UserRepository;
import domainstructure.domainstructure.core.user.service.PasswordEncryptor;
import domainstructure.domainstructure.core.user.service.UserRegistrationPolicy;
import domainstructure.domainstructure.core.user.vo.Account;
import domainstructure.domainstructure.core.user.vo.City;
import domainstructure.domainstructure.core.user.vo.HashedPassword;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
        Email email = request.email();
        if (!userRegistrationPolicy.canRegisterWith(email)) {
            throw new ApplicationException("이미 등록된 이메일", HttpStatus.BAD_REQUEST, request.email().toString());
        }

        HashedPassword hashedPassword = passwordEncryptor.encode(request.password());
        Account account = Account.of(request.email(), hashedPassword);
        Profile profile = Profile.of(request.nickname(), request.birthday());
        Address address = Address.of(City.from(request.city()), request.street(), request.zipcode());

        User newUser = User.create(account, profile, address);
        return userRepository.save(newUser);
    }
}
