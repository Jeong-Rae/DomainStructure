package domainstructure.domainstructure.infrastructure.user.embeddable;

import domainstructure.domainstructure.core.common.vo.Email;
import domainstructure.domainstructure.core.user.vo.Account;
import domainstructure.domainstructure.core.user.vo.HashedPassword;
import domainstructure.domainstructure.infrastructure.common.converter.EmailConverter;
import domainstructure.domainstructure.infrastructure.user.converter.HashedPasswordConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class AccountEmbeddable {
    @Convert(converter = EmailConverter.class)
    private Email username;

    @Convert(converter = HashedPasswordConverter.class)
    private HashedPassword password;

    private AccountEmbeddable(Email username, HashedPassword password) {
        this.username = username;
        this.password = password;
    }

    public static AccountEmbeddable of(final Account account) {
        return new AccountEmbeddable(account.getUsername(), account.getPassword());
    }
}
