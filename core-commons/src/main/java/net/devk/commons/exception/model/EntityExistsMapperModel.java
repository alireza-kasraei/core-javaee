package net.devk.commons.exception.model;

/**
 * Created by shsabet on 10/21/2018.
 */
public class EntityExistsMapperModel extends ExceptionMapperModel {

    private final String argumentName;

    public EntityExistsMapperModel(String statusCode, String errorMessage, String additionalDescription,
                                   String argumentName) {
        super(statusCode, errorMessage, additionalDescription);
        this.argumentName = argumentName;
    }

    public String getArgumentName() {
        return argumentName;
    }

}
