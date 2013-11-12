package de.shop.bestellverwaltung.rest;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import de.shop.bestellverwaltung.service.InvalidBestellungIdException;
import de.shop.util.Log;
import de.shop.util.Messages;

@Provider
@Log
public class BestellungIdNotExistExceptionMapper implements ExceptionMapper<InvalidBestellungIdException> {
	@Context
	private HttpHeaders headers;
	
	@Inject
	private Messages messages;
	
	@Override
	public Response toResponse(InvalidBestellungIdException e) {
		final String msg = messages.getMessage(headers, e.getMessageKey(), e.getBestellungId());
		return Response.status(BAD_REQUEST)
		               .type(TEXT_PLAIN)
		               .entity(msg)
		               .build();
	}
	
	
	
	
	
	
	

}
