package domainstructure.domainstructure.application.user.dto;

import domainstructure.domainstructure.core.user.model.User;

public record UserResponse(
        User user
) {

    public static UserResponse of(User user) {
        return new UserResponse(user);
    }
}
