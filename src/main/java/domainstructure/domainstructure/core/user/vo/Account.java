package domainstructure.domainstructure.core.user.vo;

import domainstructure.domainstructure.core.common.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder(toBuilder = true)
public class Account {
    private final HashedPassword password;
    private final Email username;

    private Account(Email username, HashedPassword password) {
        validate(username, password);
        this.username = username;
        this.password = password;
    }

    public static Account of(final Email username, final HashedPassword password) {
        return Account.builder()
                      .username(username)
                      .password(password)
                      .build();
    }

    private void validate(Email username, HashedPassword password) {
        if (username == null) {
            throw new IllegalArgumentException("username must not be null");
        }

        if (password == null) {
            throw new IllegalArgumentException("password must not be null");
        }
    }
}
