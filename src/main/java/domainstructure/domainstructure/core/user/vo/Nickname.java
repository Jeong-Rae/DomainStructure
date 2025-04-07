package domainstructure.domainstructure.core.user.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Optional;

@Getter
@EqualsAndHashCode
public class Nickname {
    private static final int MAX_NICKNAME_LENGTH = 10;
    private final String value;

    private Nickname(String value) {
        validate(value);
        this.value = value;
    }

    @JsonCreator
    public static Nickname of(String value) {
        return new Nickname(value);
    }

    private void validate(String value) {
        Optional.ofNullable(value)
                .filter(v -> !v.isBlank())
                .filter(v -> v.length() <= MAX_NICKNAME_LENGTH)
                .orElseThrow(() -> new IllegalArgumentException("Invalid nickname"));
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }

}
