package ua.recruitment.system.service.exception;

/**
 * Created by Kyrylo_Kovalchuk on 11/10/2016.
 */
public class UniqueConstraintViolation extends RuntimeException {

    public UniqueConstraintViolation(final String message) {
        super(message);
    }
}
