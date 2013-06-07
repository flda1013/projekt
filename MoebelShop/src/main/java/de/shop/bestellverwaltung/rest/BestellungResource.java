package de.shop.bestellverwaltung.rest;


import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.lang.invoke.MethodHandles;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;
import org.jboss.logging.Logger;
import de.shop.artikelverwaltung.rest.UriHelperArtikel;
import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.bestellverwaltung.service.BestellungService;
import de.shop.util.LocaleHelper;
import de.shop.util.Log;
import de.shop.util.NotFoundException;

@Path("/bestellungen")
@Produces(APPLICATION_JSON)
@Consumes
@Log
public class BestellungResource {
	
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());
	
	@Context	
	private UriInfo uriInfo;
	
//	@Inject
//	private UriHelperBestellung uriHelperBestellung;
//	
	
	@Inject
	private UriHelperArtikel uriHelperArtikel;
	
	@Inject
	private BestellungService bs;
	
	@Inject
	private LocaleHelper localeHelper;
	
	@Context
	private HttpHeaders headers;
	
	@PostConstruct
	private void postConstruct() {
		LOGGER.debugf("CDI-faehiges Bean %s wurde erzeugt", this);
	}
	
	@PreDestroy
	private void preDestroy() {
		LOGGER.debugf("CDI-faehiges Bean %s wird geloescht", this);
	}
	
	@GET
	@Path("{id:[1-9][0-9]*}")
	@Produces("application/json")
	public Bestellung findBestellung(@PathParam("id") Long id) {
		final Bestellung bestellung = bs.findBestellungId(id);
		if (bestellung== null) {
			final String msg = "Keine Bestellung gefunden mit der ID " + id;
			throw new NotFoundException(msg);
		}

		return bestellung;
	}
}
//	@GET
//	@Path("{id:[1-9][0-9]*}")
//	public Bestellung findBestellungById(@PathParam("id") Long id) {
//		final Bestellung bestellung = bs.findBestellungById(id);
//		if (bestellung == null) {
//			throw new NotFoundException("Keine Bestellung mit der ID " + id + " gefunden.");
//		}
//		final Artikel artikel = as.findArtikelById(id);
//		final BestellPosition bestellPosition = bp.findBestellPositionById(id);
//		// URLs innerhalb der gefundenen Bestellung anpassen
//		
//		final List<BestellPosition> bestellPositionen = new ArrayList<>();
//		
//		uriHelperBestellung.updateUriBestellung(bestellung, uriInfo);
//		bestellPosition.setArtikelUri(uriHelperArtikel.getUriArtikel(artikel, uriInfo));
//		
//		bestellPosition.setBestellungURI(uriHelperBestellung.getUriBestellung(bestellung, uriInfo));
//	
//		bestellPositionen.add(bestellPosition);
//		bestellung.setBestellPositionen(bestellPositionen);
//		
//		
//		
//		return bestellung;
//	}
//	
////	@GET
////	@Path("{id:[1-9][0-9]*}/bestellPosition")
////	public Collection<BestellPosition> findBestellPositionenByBestellungId(@PathParam("id") Long bestellungId) {
////		final Collection<BestellPosition> bestellPositionen = bs.findBestellPositionenByBestellungId(bestellungId);
////		if (bestellPositionen.isEmpty()) {
////			throw new NotFoundException("Zur ID " + bestellungId + " wurden keine BestellPositionen gefunden");
////		}
////		
////		// URLs innerhalb der gefundenen BestellPosition anpassen
////		for (BestellPosition bestellPosition : bestellPositionen) {
////			uriHelperBestellPosition.updateUriBestellPosition(bestellPosition, uriInfo);
////		}
////		
////		return bestellPositionen;
////	}
//	
//	@POST
//	@Consumes(APPLICATION_JSON)
//	@Produces
//	public Response createBestellung(Bestellung bestellung) {
//		
//		final Locale locale = localeHelper.getLocale(headers);
//		
//		
//		final URI kundeUri = bestellung.getKundeUri();
//		final String kundeUriString = kundeUri.toString();
//		final String stringKundeId = kundeUriString.substring(kundeUriString.lastIndexOf("/") + 1);
//		final Long kundeId = Long.valueOf(stringKundeId);
//		final AbstractKunde kunde  = ks.findKundeById(kundeId, locale);
//		bestellung.setKunde(kunde);	
//		final BestellPosition bestellPosition = bp.createBestellPosition(new BestellPosition());
//		
//		
//		
//		
////		kunde.getBestellungen().add(bestellung);
//	
//		final ArrayList<BestellPosition> bestellPositionen = new ArrayList<>();
//		final URI artikelURI = uriHelperArtikel.getUriArtikel(bestellPosition.getArtikel(), uriInfo);
//			
//		bestellPosition.setArtikelUri(artikelURI);
//		bestellPositionen.add(bestellPosition);
//		bestellung.setBestellPositionen(bestellPositionen);	
//		bestellung = bs.createBestellung(bestellung, locale);
//		
//		
//		final URI bestellungUri = uriHelperBestellung.getUriBestellung(bestellung, uriInfo);
//		return Response.created(bestellungUri).build();
//		
//		
//		
//	}
//}
