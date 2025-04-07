package domainstructure.domainstructure.application.user.assembler;

import domainstructure.domainstructure.application.user.dto.UserRegisterRequest;
import domainstructure.domainstructure.core.user.model.Address;
import domainstructure.domainstructure.core.user.model.Profile;
import domainstructure.domainstructure.core.user.model.User;
import domainstructure.domainstructure.core.user.vo.Account;
import domainstructure.domainstructure.core.user.vo.City;
import domainstructure.domainstructure.core.user.vo.HashedPassword;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserRegisterAssembler {
    public static User toUser(UserRegisterRequest request, HashedPassword hashedPassword) {
        return User.create(
                Account.of(request.email(), hashedPassword),
                toProfile(request),
                toAddress(request)
        );
    }

    public static Profile toProfile(UserRegisterRequest request) {
        return Profile.of(request.nickname(), request.birthday());
    }

    public static Address toAddress(UserRegisterRequest request) {
        return Address.of(City.from(request.city()), request.street(), request.zipcode());
    }
}
