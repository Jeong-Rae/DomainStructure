package domainstructure.domainstructure.core.common.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Optional;

@Getter
@EqualsAndHashCode
public class Email {
    private static final String EMAIL_REGEX = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
    private static final String INVALID_EMAIL_MESSAGE = "Invalid email address";
    private static final int MAX_EMAIL_LENGTH = 254;
    private final String value;

    private Email(String value) {
        validate(value);
        this.value = value;
    }

    @JsonCreator
    public static Email of(final String value) {
        return new Email(value);
    }

    private void validate(String value) {
        Optional.ofNullable(value)
                .filter(v -> !v.isBlank())
                .filter(this::isValidFormat)
                .filter(v -> v.length() <= MAX_EMAIL_LENGTH)
                .orElseThrow(() -> new IllegalArgumentException(INVALID_EMAIL_MESSAGE));
    }

    private boolean isValidFormat(String value) {
        return value.matches(EMAIL_REGEX);
    }

    @Override
    @JsonValue
    public String toString() {
        return value;
    }
}
