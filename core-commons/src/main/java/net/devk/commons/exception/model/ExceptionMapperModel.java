package net.devk.commons.exception.model;

import lombok.Data;

@Data
public class ExceptionMapperModel {
	private final String statusCode;
	private final String errorMessage;
	private final String additionalDescription;
}
