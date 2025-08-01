package com.ctw.workstation.exceptionMapper;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GenericHibernateExceptionMapper implements ExceptionMapper<RuntimeException> {
 @Override
 public Response toResponse(RuntimeException exception) {
     return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
             .entity("An unexpected error occurred: " + exception.getMessage())
             .build();
 }
}
