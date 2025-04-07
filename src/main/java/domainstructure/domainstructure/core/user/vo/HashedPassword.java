package domainstructure.domainstructure.core.user.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Optional;

@Getter
@EqualsAndHashCode
public class HashedPassword {
    private static final String INVALID_PASSWORD_MESSAGE = "invalid password";
    private final String value;

    private HashedPassword(String value) {
        validate(value);
        this.value = value;
    }

    @JsonCreator
    public static HashedPassword of(final String value) {
        return new HashedPassword(value);
    }

    private void validate(String value) {
        Optional.ofNullable(value).orElseThrow(() -> new IllegalArgumentException(INVALID_PASSWORD_MESSAGE));
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }
}
