package domainstructure.domainstructure.infrastructure.security;

public class PasswordEncoder {
    public String encode(String rawPassword) {
        return rawPassword;
    }

    public boolean matches(String rawPassword, String encodedPassword) {
        return rawPassword.equals(encodedPassword);
    }

}
