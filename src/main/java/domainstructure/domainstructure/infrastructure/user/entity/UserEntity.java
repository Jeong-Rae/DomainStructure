package domainstructure.domainstructure.infrastructure.user.entity;

import domainstructure.domainstructure.core.user.vo.UserID;
import domainstructure.domainstructure.infrastructure.user.converter.UserIDConverter;
import domainstructure.domainstructure.infrastructure.user.embeddable.AccountEmbeddable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
public class UserEntity {
    @Id
    @Convert(converter = UserIDConverter.class)
    @Column(columnDefinition = "binary(16)")
    private UserID id;

    @Embedded
    private AccountEmbeddable account;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ProfileEntity profile;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AddressEntity address;

    private UserEntity(UserID id, AccountEmbeddable account, ProfileEntity profile, AddressEntity address) {
        this.id = id;
        this.account = account;
        this.profile = profile;
        this.address = address;
    }

    public static UserEntity of(UserID id, AccountEmbeddable account, ProfileEntity profile, AddressEntity address) {
        UserEntity entity = new UserEntity(id, account, profile, address);

        if (profile != null) {
            profile.associateUser(entity);
        }
        if (address != null) {
            address.associateUser(entity);
        }
        return entity;
    }


}
