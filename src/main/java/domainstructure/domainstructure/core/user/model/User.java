package domainstructure.domainstructure.core.user.model;

import domainstructure.domainstructure.core.user.support.UserIDGenerator;
import domainstructure.domainstructure.core.user.vo.Account;
import domainstructure.domainstructure.core.user.vo.UserID;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class User {
    private final Account account;
    private final Address address;
    private final UserID id;
    private final Profile profile;

    @Builder(toBuilder = true)
    private User(UserID id, Account account, Profile profile, Address address) {
        this.id = id;
        this.account = account;
        this.profile = profile;
        this.address = address;
    }

    public static User of(UserID id, Account account, Profile profile, Address address) {
        return User.builder().id(id).account(account).profile(profile).address(address).build();
    }

    public static User create(Account account, Profile profile, Address address) {
        return User.builder()
                   .id(UserIDGenerator.generate())
                   .account(account)
                   .profile(profile)
                   .address(address)
                   .build();
    }
}
