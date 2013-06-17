package de.shop.bestellverwaltung.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
//import java.net.URI;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
//import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
//import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;
//import de.shop.artikelverwaltung.domain.Artikel;
import de.shop.artikelverwaltung.service.ArtikelService;
import de.shop.bestellverwaltung.domain.Bestellposition;
import de.shop.bestellverwaltung.service.BestellPositionService;
//import de.shop.util.LocaleHelper;
import de.shop.util.Log;
import de.shop.util.NotFoundException;
import de.shop.util.Transactional;


@Path("/bestellposition")
@Produces(APPLICATION_JSON)
@Consumes
@RequestScoped
@Transactional
@Log
public class BestellPositionResource {
//	@Context
//	private UriInfo uriInfo;

//	@Context
//	private HttpHeaders headers;

	@Inject
	private UriHelperBestellPosition uriHelperBestellPosition;

//	@Inject
//	private LocaleHelper localeHelper;
	
	@Inject
	private BestellPositionService bs;

	@Inject
	private ArtikelService as;
	
	@GET
	@Path("{id:[1-9][0-9]*}")
	@Produces("application/json")
	public Bestellposition findBestellposition(@PathParam("id") Long id, @Context UriInfo uriInfo) {
		final Bestellposition bestellposition = bs.findBestellpositionById(id);
		if (bestellposition == null) {
			final String msg = "Keine BestellPosition gefunden mit der ID " + id;
			throw new NotFoundException(msg);
		}
		uriHelperBestellPosition.getUriBestellPosition(bestellposition, uriInfo);
		return bestellposition;
		
	}
	
//	@Consumes(APPLICATION_JSON)
//	@Produces("application/json")
//	public Bestellposition createBestellPosition(Bestellposition bestellposition) {
//		final URI artikelUri = bestellposition.getArtikelUri();
//		final String artikelUriString = artikelUri.toString();
//		final String stringArtikelId = artikelUriString.substring(artikelUriString.lastIndexOf("/") + 1);
//		final Long artikelId = Long.valueOf(stringArtikelId);
//		final Artikel artikel  = as.findArtikelById(artikelId);
//		
//		bestellposition.setArtikel(artikel);
//		
//		bestellposition = bs.createBestellPosition(bestellposition);
//		
//		return bestellposition;
//	}
//	
}
