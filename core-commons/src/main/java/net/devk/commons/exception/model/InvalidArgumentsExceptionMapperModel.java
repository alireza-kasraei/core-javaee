package net.devk.commons.exception.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InvalidArgumentsExceptionMapperModel extends ExceptionMapperModel {

	private final String argumentName;

	public InvalidArgumentsExceptionMapperModel(String statusCode, String errorMessage, String additionalDescription,
			String argumentName) {
		super(statusCode, errorMessage, additionalDescription);
		this.argumentName = argumentName;
	}

}
