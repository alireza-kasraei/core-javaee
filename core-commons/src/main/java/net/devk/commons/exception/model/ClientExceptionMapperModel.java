package net.devk.commons.exception.model;

public class ClientExceptionMapperModel extends ExceptionMapperModel {

    private final String argumentName;

    public ClientExceptionMapperModel(String statusCode, String errorMessage, String additionalDescription,
                                      String argumentName) {
        super(statusCode, errorMessage, additionalDescription);
        this.argumentName = argumentName;
    }

    public String getArgumentName() {
        return argumentName;
    }

}
