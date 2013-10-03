package de.shop.util;

import java.net.URI;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.UriInfo;


@ApplicationScoped
@Log
public class UriHelper {
	public URI getUri(Class<?> clazz, UriInfo uriInfo) {
		return uriInfo.getBaseUriBuilder()
				      .path(clazz)
				      .build();
	}

	public URI getUri(Class<?> clazz, String methodName, Long id, UriInfo uriInfo) {
		return uriInfo.getBaseUriBuilder()
		              .path(clazz)
		              .path(clazz, methodName)
		              .build(id);
	}
}
