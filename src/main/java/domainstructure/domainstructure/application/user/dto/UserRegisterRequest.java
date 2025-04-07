package domainstructure.domainstructure.application.user.dto;

import domainstructure.domainstructure.core.common.vo.Email;
import domainstructure.domainstructure.core.user.vo.Nickname;

import java.time.LocalDate;

public record UserRegisterRequest(
        Email email,
        String password,
        Nickname nickname,
        LocalDate birthday,
        String city,
        String street,
        String zipcode
) {
}
