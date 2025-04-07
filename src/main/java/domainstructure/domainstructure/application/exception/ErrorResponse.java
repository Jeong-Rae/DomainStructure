package domainstructure.domainstructure.application.exception;

public record ErrorResponse(
        String message,
        String code,
        String details
) {
    public static ErrorResponse of(ApplicationException e) {
        return new ErrorResponse(
                e.getMessage(),
                e.getCode(),
                e.getDetails()
        );
    }
}