package de.shop.artikelverwaltung.rest;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import de.shop.artikelverwaltung.service.InvalidArtikelIdException;
import de.shop.util.Log;
import de.shop.util.Messages;

@Provider
@Log
public class ArtikelIdNotExistExceptionMapper implements ExceptionMapper<InvalidArtikelIdException> {
	@Context
	private HttpHeaders headers;
	
	@Inject
	private Messages messages;
	
	@Override
	public Response toResponse(InvalidArtikelIdException e) {
		final String msg = messages.getMessage(headers, e.getMessageKey(), e.getArtikelId());
		return Response.status(BAD_REQUEST)
		               .type(TEXT_PLAIN)
		               .entity(msg)
		               .build();
	}
	
	
	
	
	
	
	

}
