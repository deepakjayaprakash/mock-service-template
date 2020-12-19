package com.serivce.mock.handler;


import com.serivce.mock.exception.ApplicationException;
import com.serivce.mock.exception.WrappedException;
import com.serivce.mock.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
@Slf4j
public class ApplicationExceptionHandler {

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(WrappedException.class)
    @ResponseBody
    public ResponseDTO handleException(WrappedException e) {
        ResponseDTO responseDTO = new ResponseDTO();
        return responseDTO;
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ApplicationException.class)
    @ResponseBody
    public ResponseDTO handleValidationException(ApplicationException e) {
        ResponseDTO responseDTO = new ResponseDTO();
        return responseDTO;
    }
}
