package com.sadad.web.exception.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.devk.commons.exception.model.ExceptionMapperModel;


/**
 * general exception mapper
 * 
 * add your own mapper for each custom exception
 */
@Provider
public class GeneralExceptionMapper implements ExceptionMapper<Throwable> {

	private static final Logger log = LoggerFactory.getLogger(GeneralExceptionMapper.class);

	@Override
	public Response toResponse(Throwable throwable) {
		log.error("general exception mapper catched exception", throwable);
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(new ExceptionMapperModel(null, throwable.getMessage(), null)).type(MediaType.APPLICATION_JSON)
				.build();
	}

}
