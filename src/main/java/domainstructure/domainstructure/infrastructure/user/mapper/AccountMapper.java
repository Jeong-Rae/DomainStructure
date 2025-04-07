package domainstructure.domainstructure.infrastructure.user.mapper;

import domainstructure.domainstructure.core.user.vo.Account;
import domainstructure.domainstructure.infrastructure.user.embeddable.AccountEmbeddable;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountMapper {
    public static AccountEmbeddable toEmbeddable(Account account) {
        return AccountEmbeddable.of(account);
    }

    public static Account toDomain(AccountEmbeddable embeddable) {
        if (embeddable == null) {
            return null;
        }
        return Account.of(embeddable.getUsername(), embeddable.getPassword());
    }
}
