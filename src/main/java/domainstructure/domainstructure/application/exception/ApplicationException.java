package domainstructure.domainstructure.application.exception;

import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException {
    private final String details;
    private final ErrorCode errorCode;

    public ApplicationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.details = null;
    }

    public ApplicationException(ErrorCode errorCode, String details) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.details = details;
    }

    public String getMessage() {
        return errorCode.getMessage();
    }

    public HttpStatus getHttpStatus() {
        return errorCode.getStatus();
    }

    public String getCode() {
        return errorCode.getCode();
    }

    public String getDetails() {
        return details;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
