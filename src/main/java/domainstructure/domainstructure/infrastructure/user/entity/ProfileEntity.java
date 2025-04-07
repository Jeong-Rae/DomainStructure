package domainstructure.domainstructure.infrastructure.user.entity;

import domainstructure.domainstructure.core.user.vo.Nickname;
import domainstructure.domainstructure.infrastructure.user.converter.NicknameConverter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "profile")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @Convert(converter = NicknameConverter.class)
    private Nickname nickname;

    @Column(name = "birthday")
    private LocalDate birthday;

    private ProfileEntity(Long id, Nickname nickname, LocalDate birthday) {
        this.id = id;
        this.nickname = nickname;
        this.birthday = birthday;
    }

    public static ProfileEntity of(Long id, Nickname nickname, LocalDate birthday) {
        return new ProfileEntity(id, nickname, birthday);
    }
}
