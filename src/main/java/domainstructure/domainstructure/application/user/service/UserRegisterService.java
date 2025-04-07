package domainstructure.domainstructure.application.user.service;

import domainstructure.domainstructure.application.user.dto.UserRegisterRequest;
import domainstructure.domainstructure.core.user.model.Address;
import domainstructure.domainstructure.core.user.model.Profile;
import domainstructure.domainstructure.core.user.model.User;
import domainstructure.domainstructure.core.user.service.PasswordEncryptor;
import domainstructure.domainstructure.core.user.vo.Account;
import domainstructure.domainstructure.core.user.vo.City;
import domainstructure.domainstructure.core.user.vo.HashedPassword;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserRegisterService {
    private final PasswordEncryptor passwordEncryptor;

    @Transactional
    public void register(UserRegisterRequest request) {
        HashedPassword hashedPassword = passwordEncryptor.encode(request.password());
        Account account = Account.of(request.email(), hashedPassword);
        Profile profile = Profile.of(request.nickname(), request.birthday());
        Address address = Address.of(City.from(request.city()), request.street(), request.zipcode());

        User user = User.create(account, profile, address);
    }
}
