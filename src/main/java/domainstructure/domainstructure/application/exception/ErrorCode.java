package domainstructure.domainstructure.application.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    DUPLICATED_EMAIL("이미 등록된 이메일입니다.", "USER_001", HttpStatus.BAD_REQUEST),
    WEAK_PASSWORD("비밀번호 조건이 만족하지 않습니다.", "AUTH_001", HttpStatus.BAD_REQUEST);


    private final String code;
    private final String message;
    private final HttpStatus status;

    ErrorCode(String message, String code, HttpStatus status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }
}
