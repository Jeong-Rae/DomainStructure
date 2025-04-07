package domainstructure.domainstructure.core.user.vo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class UserID {
    private final String value;

    private UserID(String value) {
        validate(value);
        this.value = value;
    }

    @JsonCreator
    public static UserID of(String value) {
        return new UserID(value);
    }

    private void validate(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Invalid user ID");
        }
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }
}
