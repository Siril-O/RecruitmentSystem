package ua.recruitment.system.web.controller.common;

/**
 * Created by Kyrylo_Kovalchuk on 11/8/2016.
 */
public class FieldErrorResource {
    private String resource;
    private String field;
    private String code;
    private String message;

    public String getResource() {
        return resource;
    }

    public void setResource(final String resource) {
        this.resource = resource;
    }

    public String getField() {
        return field;
    }

    public void setField(final String field) {
        this.field = field;
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
}
