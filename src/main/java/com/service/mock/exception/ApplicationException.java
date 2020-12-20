package com.service.mock.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ApplicationException extends Exception {
    private static final long serialVersionUID = -5124402958603233368L;
    private String errorMessage;
    private String identifier;
    private String displayMessage;
}
