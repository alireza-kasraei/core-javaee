package com.sadad.web.exception.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.devk.commons.exception.EntityNotFoundException;
import net.devk.commons.exception.model.ClientExceptionMapperModel;

@Provider
public class EntityNotFoundExceptionMapper implements ExceptionMapper<EntityNotFoundException> {

    private static final Logger log = LoggerFactory.getLogger(EntityNotFoundExceptionMapper.class);

    @Override
    public Response toResponse(EntityNotFoundException exception) {
        log.error("EntityNotFoundException mapper catched exception", exception);
        return Response
                .status(Status.NOT_FOUND).entity(new ClientExceptionMapperModel(null,
                        exception.getMessage(), null, exception.getArgumentName()))
                .type(MediaType.APPLICATION_JSON).build();
    }

}
