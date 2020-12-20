package com.service.mock.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class WrappedException extends RuntimeException {
    private static final long serialVersionUID = 7357688328864578530L;
    private final Exception exception;

    public WrappedException(Exception exception) {
        super(exception);
        this.exception = exception;
    }
}