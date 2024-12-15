package com.hhp.precourse.util.exception;

/**
 * @RestControllerAdvice 를 통해 예외 전역 처리를 위해 Enum 으로 예외를 정의해준다!
 */
public enum ErrorCode {

    INVALID_TOKEN("INVALID_TOKEN", "Invalid Token."),
    USER_NOT_FOUND("USER_NOT_FOUND", "The requested user does not exist."),
    INVALID_INPUT("INVALID_INPUT", "The provided input is invalid."),
    INTERNAL_ERROR("INTERNAL_ERROR", "An unexpected error occurred. Please try again later.");

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
