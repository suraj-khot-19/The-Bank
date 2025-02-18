package com.suraj.TheBank.exception;
import java.time.LocalDateTime;

/// record class for error details
public record ErrorDetails(
        LocalDateTime timestamp,
        String message,
        String errorCode,
        String details
) {

}
