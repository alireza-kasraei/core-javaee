package com.sadad.web.exception.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.devk.commons.exception.InvalidArgumentsException;
import net.devk.commons.exception.model.InvalidArgumentsExceptionMapperModel;


@Provider
public class InvalidArgumentsExceptionMapper implements ExceptionMapper<InvalidArgumentsException> {

	private static final Logger log = LoggerFactory.getLogger(InvalidArgumentsExceptionMapper.class);

	@Override
	public Response toResponse(InvalidArgumentsException exception) {
		log.error("invalid argument exception mapper catched exception", exception);
		return Response
				.status(Status.BAD_REQUEST).entity(new InvalidArgumentsExceptionMapperModel(null,
						exception.getMessage(), null, exception.getArgumentName()))
				.type(MediaType.APPLICATION_JSON).build();
	}

}
