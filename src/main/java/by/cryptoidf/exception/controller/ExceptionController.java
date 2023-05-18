package by.cryptoidf.exception.controller;

import by.cryptoidf.exception.dto.CurrencyException;
import by.cryptoidf.exception.dto.UserException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler({CurrencyException.class, UserException.class})
    public ResponseEntity<String> handleMethodFamilyNotFoundException(Exception exception){
        log.warn(exception.getMessage());
        return new ResponseEntity<>(exception.getMessage(), BAD_REQUEST);
    }
}
