package net.devk.commons.exception;

import javax.ejb.ApplicationException;

/**
 * Created by shsabet on 10/21/2018.
 */
@ApplicationException(rollback = true)
public class EntityExistsException extends RuntimeException {

    private static final long serialVersionUID = 6404006940941447095L;

    private String argumentName;

    public EntityExistsException() {
    }

    public EntityExistsException(String message) {
        super(message);
    }

    public EntityExistsException(String argumentName, String message) {
        super(message);
        this.argumentName = argumentName;
    }

    public String getArgumentName() {
        return argumentName;
    }

}
