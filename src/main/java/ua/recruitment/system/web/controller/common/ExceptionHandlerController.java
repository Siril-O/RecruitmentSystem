package ua.recruitment.system.web.controller.common;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Kyrylo_Kovalchuk on 11/8/2016.
 */
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public InvalidFieldsErrrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        List<FieldErrorResource> fieldErrorResources = fieldErrors.stream().map(this::buildFieldErrorResource)
                .collect(Collectors.toList());
        InvalidFieldsErrrorResponse response = new InvalidFieldsErrrorResponse("InvalidRequest", exception.getMessage());
        response.setFieldErrors(fieldErrorResources);

        return response;
    }

    private FieldErrorResource buildFieldErrorResource(FieldError fieldError) {
        FieldErrorResource fieldErrorResource = new FieldErrorResource();
        fieldErrorResource.setResource(fieldError.getObjectName());
        fieldErrorResource.setField(fieldError.getField());
        fieldErrorResource.setCode(fieldError.getCode());
        fieldErrorResource.setMessage(fieldError.getDefaultMessage());
        return fieldErrorResource;
    }
}
