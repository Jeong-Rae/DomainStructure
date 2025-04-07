package domainstructure.domainstructure.core.user.model;

import domainstructure.domainstructure.core.user.vo.Nickname;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Profile {
    private final LocalDate birthday;
    private final Long id;
    private final Nickname name;

    @Builder(toBuilder = true)
    private Profile(Long id, Nickname name, LocalDate birthday) {
        validate(name, birthday);
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }

    public static Profile of(Long id, Nickname name, LocalDate birthday) {
        return new Profile(id, name, birthday);
    }

    public static Profile of(Nickname name, LocalDate birthday) {
        return new Profile(null, name, birthday);
    }

    private void validate(Nickname name, LocalDate birthday) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }
        if (birthday == null) {
            throw new IllegalArgumentException("birthday must not be null");
        }
    }


}
