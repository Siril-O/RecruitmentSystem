package ua.recruitment.system.web.controller.common;

/**
 * Created by Kyrylo_Kovalchuk on 11/10/2016.
 */
public class ErrorInfo {

    private final String message;
    private final Exception ex;

    public ErrorInfo(final String message, final Exception ex) {
        this.message = message;
        this.ex = ex;
    }

    public String getMessage() {
        return message;
    }

    public Exception getEx() {
        return ex;
    }
}
