package com.projetofinal.ticher.config.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionErrorHandler {

    private final MessageSource messageSource;

    @Autowired
    public ExceptionErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<?> handle(MethodArgumentNotValidException exception) {
        List<Object> dto = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String mensage = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErrorResponse response = new ErrorResponse(e.getField(), mensage);
            dto.add(response);
        });

        List<ObjectError> errors = exception.getBindingResult().getGlobalErrors();
        errors.forEach(e -> {
            String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            GlobalErrorResponse error = new GlobalErrorResponse(message);
            dto.add(error);
        });

        return dto;
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> customHandler(CustomException e) {
        GlobalErrorResponse globalResponse = new GlobalErrorResponse(e.getMessage());
        return ResponseEntity.status(e.getHttpStatus()).body(globalResponse);
    }

}
