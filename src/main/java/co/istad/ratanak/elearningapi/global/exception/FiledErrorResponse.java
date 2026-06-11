package co.istad.ratanak.elearningapi.global.exception;

public record FiledErrorResponse(
        String filed,
        String reason
) {
}
