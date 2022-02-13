package com.example.map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Employee Not Found")
public class NotFoundAnyMatchException extends Exception{

    public NotFoundAnyMatchException() {
    }

    public NotFoundAnyMatchException(String s) {
        super(s);
    }

    public NotFoundAnyMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundAnyMatchException(Throwable cause) {
        super(cause);
    }

    public NotFoundAnyMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
