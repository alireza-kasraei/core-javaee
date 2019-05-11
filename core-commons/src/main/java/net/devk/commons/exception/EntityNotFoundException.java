package net.devk.commons.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class EntityNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -3413482527843586591L;

    private String argumentName;

    public EntityNotFoundException() {
    }

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String argumentName, String message) {
        super(message);
        this.argumentName = argumentName;
    }

    public String getArgumentName() {
        return argumentName;
    }

}
