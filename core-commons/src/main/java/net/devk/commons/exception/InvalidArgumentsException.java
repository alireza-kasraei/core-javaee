package net.devk.commons.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class InvalidArgumentsException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String argumentName;

	public InvalidArgumentsException() {
	}

	public InvalidArgumentsException(String message) {
		super(message);
	}

	public InvalidArgumentsException(String argumentName, String message) {
		super(message);
		this.argumentName = argumentName;
	}

	public String getArgumentName() {
		return argumentName;
	}

}
