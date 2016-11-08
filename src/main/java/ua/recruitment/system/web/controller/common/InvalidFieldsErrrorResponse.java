package ua.recruitment.system.web.controller.common;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Kyrylo_Kovalchuk on 11/8/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvalidFieldsErrrorResponse {

    private String code;
    private String message;
    private List<FieldErrorResource> fieldErrors;

    public InvalidFieldsErrrorResponse() {
    }

    public InvalidFieldsErrrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public List<FieldErrorResource> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(final List<FieldErrorResource> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
