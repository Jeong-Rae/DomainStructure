package domainstructure.domainstructure.application.exception;

import org.springframework.http.HttpStatus;

public class ApplicationException extends RuntimeException {
    private HttpStatus httpStatus;
    private String details;

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, HttpStatus httpStatus, String details) {
        super(message);
        this.httpStatus = httpStatus;
        this.details = details;
    }

    public ApplicationException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
