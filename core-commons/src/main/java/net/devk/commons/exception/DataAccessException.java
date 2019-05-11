package net.devk.commons.exception;

/**
 * base wrapper exception for underlying persistence exceptions
 */
public class DataAccessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Throwable main;
	private String message;

	public DataAccessException(String message) {
		this.message = message;
	}

	public DataAccessException(Throwable main) {
		this.main = main;
	}

	public DataAccessException(String message, Throwable main) {
		this.message = message;
		this.main = main;
	}

	public Throwable getMain() {
		return main;
	}

	public String getMessage() {
		return message;
	}

}
