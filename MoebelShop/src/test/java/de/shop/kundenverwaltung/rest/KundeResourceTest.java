package de.shop.kundenverwaltung.rest;

import static de.shop.util.TestConstants.USERNAME;
import static de.shop.util.TestConstants.ARTIKEL_URI;
import static java.net.HttpURLConnection.HTTP_BAD_REQUEST;
import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.util.Locale.ENGLISH;
import static de.shop.util.TestConstants.ARTIKEL_BEZEICHNUNG_FALSCH;
import static de.shop.util.TestConstants.KUNDEN_URI;
import static de.shop.util.TestConstants.BESTELLUNGEN_URI;
import static de.shop.util.TestConstants.PASSWORD;
import static de.shop.util.TestConstants.NEUE_PLZ_FALSCH;
import static de.shop.util.TestConstants.USERNAME_ADMIN;
import static de.shop.util.TestConstants.NEUE_EMAIL_OHNE;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.filter;

import java.lang.invoke.MethodHandles;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Logger;

import static javax.ws.rs.client.Entity.json;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.resteasy.api.validation.ResteasyConstraintViolation;
import org.jboss.resteasy.api.validation.ViolationReport;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.shop.auth.domain.RolleType;
import de.shop.bestellverwaltung.domain.Bestellposition;
import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.kundenverwaltung.domain.Adresse;
import de.shop.kundenverwaltung.domain.Privatkunde;
import de.shop.util.AbstractResourceTest;

import javax.ws.rs.core.Response;


//Logging durch java.util.logging
/**
 * @author <a href="mailto:Juergen.Zimmermann@HS-Karlsruhe.de">J&uuml;rgen Zimmermann</a>
 */
@RunWith(Arquillian.class)
public class KundeResourceTest extends AbstractResourceTest {

private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());
	
	private static final String NEUER_NACHNAME = "Nachnameneu";
	private static final String NEUER_VORNAME = "Vorname";
	private static final String NEUE_EMAIL = NEUER_NACHNAME + "@test.de";
	private static final BigDecimal NEUER_UMSATZ = new BigDecimal(10_000_000);
	private static final Date NEU_SEIT = new GregorianCalendar(2000, 0, 31).getTime();
	private static final String NEUE_PLZ = "76133";
	private static final String NEUER_ORT = "Karlsruhe";
	private static final String NEUE_STRASSE = "Testweg";
	private static final String NEUE_HAUSNR = "1";
	private static final String NEUES_PASSWORD = "neuesPassword";
	private static final Long ARTIKEL_ID_VORHANDEN = Long.valueOf(301);
	


	
	@Test
	@InSequence(40)
	public void createPrivatkundeMitAnmeldung() throws URISyntaxException {
		LOGGER.finer("BEGINN");
		
		
		
		// Given
		final String nachname = NEUER_NACHNAME;
		final String vorname = NEUER_VORNAME;
		final String email = NEUE_EMAIL;
		final BigDecimal umsatz = NEUER_UMSATZ;
		final Date seit = NEU_SEIT;
		final String plz = NEUE_PLZ;
		final String ort = NEUER_ORT;
		final String strasse = NEUE_STRASSE;
		final String hausnr = NEUE_HAUSNR;
		final String neuesPassword = NEUES_PASSWORD;
		
		final Privatkunde kunde = new Privatkunde();
		kunde.setVorname(vorname);
		kunde.setNachname(nachname);
		kunde.setEmail(email);
		kunde.setSeit(seit);
		kunde.setVorname(vorname);
		kunde.setUmsatz(umsatz);
		kunde.setRabatt(new BigDecimal("0.1"));

		
		final Adresse adresse = new Adresse();
		adresse.setPlz(plz);
		adresse.setOrt(ort);
		adresse.setStrasse(strasse);
		adresse.setHausnr(hausnr);
		
		kunde.setAdresse(adresse);
		kunde.setPassword(neuesPassword);
		kunde.setPasswordWdh(neuesPassword);
		kunde.addRollen(Arrays.asList(RolleType.KUNDE));
		
		Response response = getHttpsClient(USERNAME, PASSWORD).target(KUNDEN_URI)
                                                              .request()
                                                              .accept(APPLICATION_JSON)
                                                              .post(json(kunde));
			
		// Then
		assertThat(response.getStatus()).isEqualTo(HTTP_CREATED);
		String location = response.getLocation().toString();
		response.close();
		
		final int startPos = location.lastIndexOf('/');
		final String idStr = location.substring(startPos + 1);
		final Long id = Long.valueOf(idStr);
		assertThat(id).isPositive();
		
		// Einloggen als neuer Kunde und Bestellung aufgeben

		// Given (2)
		final Long artikelId = ARTIKEL_ID_VORHANDEN;
		final String username = id.toString();

		// When (2)
		final Bestellung bestellung = new Bestellung();
		final Bestellposition bp = new Bestellposition();
		bp.setArtikelUri(new URI(ARTIKEL_URI + "/" + artikelId));
		bp.setAnzahl((short) 3);
		bestellung.addBestellposition(bp);
		bestellung.setKunde(kunde);
		
		
		
		// Then (2)
		response = getHttpsClient(username, neuesPassword).target(BESTELLUNGEN_URI)
                                                          .request()
                                                          .accept(APPLICATION_JSON)
                                                          .post(json(bestellung));

		assertThat(response.getStatus()).isEqualTo(HTTP_CREATED);
		location = response.getLocation().toString();
		response.close();
		assertThat(location).isNotEmpty();

		LOGGER.finer("ENDE");

	}
	
	@Test
	@InSequence(41)
	public void createPrivatkundeOhneAnmeldung()
	{
		
		LOGGER.finer("BEGINN");
		// Given
		final String nachname = NEUER_NACHNAME;
		final String vorname = NEUER_VORNAME;
		final String email = NEUE_EMAIL_OHNE;
		final BigDecimal umsatz = NEUER_UMSATZ;
		final Date seit = NEU_SEIT;
		final String plz = NEUE_PLZ;
		final String ort = NEUER_ORT;
		final String strasse = NEUE_STRASSE;
		final String hausnr = NEUE_HAUSNR;
		final String neuesPassword = NEUES_PASSWORD;
		
		final Privatkunde kunde = new Privatkunde();
		kunde.setVorname(vorname);
		kunde.setNachname(nachname);
		kunde.setEmail(email);
		kunde.setSeit(seit);
		kunde.setVorname(vorname);
		kunde.setUmsatz(umsatz);
		kunde.setRabatt(new BigDecimal("0.1"));

		
		final Adresse adresse = new Adresse();
		adresse.setPlz(plz);
		adresse.setOrt(ort);
		adresse.setStrasse(strasse);
		adresse.setHausnr(hausnr);
		
		kunde.setAdresse(adresse);
		kunde.setPassword(neuesPassword);
		kunde.setPasswordWdh(neuesPassword);
		kunde.addRollen(Arrays.asList(RolleType.KUNDE));
		
		Response response = getHttpsClient().target(KUNDEN_URI).request().accept(APPLICATION_JSON).post(json(kunde));
			
		// Then
		assertThat(response.getStatus()).isEqualTo(HTTP_CREATED);
		response.close();
		
		LOGGER.finer("ENDE");

	}
	
	
	@Test
	@InSequence(40)
	public void createPrivatkundeValidationFehler(){
		LOGGER.finer("BEGINN");
		
		
		
		// Given
		final String nachname = NEUER_NACHNAME;
		final String vorname = NEUER_VORNAME;
		final String email = NEUE_EMAIL;
		final BigDecimal umsatz = NEUER_UMSATZ;
		final Date seit = NEU_SEIT;
		final String plz = NEUE_PLZ_FALSCH;
		final String ort = NEUER_ORT;
		final String strasse = NEUE_STRASSE;
		final String hausnr = NEUE_HAUSNR;
		final String neuesPassword = NEUES_PASSWORD;
		
		final Privatkunde kunde = new Privatkunde();
		kunde.setVorname(vorname);
		kunde.setNachname(nachname);
		kunde.setEmail(email);
		kunde.setSeit(seit);
		kunde.setVorname(vorname);
		kunde.setUmsatz(umsatz);
		kunde.setRabatt(new BigDecimal("0.1"));

		
		final Adresse adresse = new Adresse();
		adresse.setPlz(plz);
		adresse.setOrt(ort);
		adresse.setStrasse(strasse);
		adresse.setHausnr(hausnr);
		
		kunde.setAdresse(adresse);
		kunde.setPassword(neuesPassword);
		kunde.setPasswordWdh(neuesPassword);
		kunde.addRollen(Arrays.asList(RolleType.KUNDE));
		
		final Response response = getHttpsClient().target(KUNDEN_URI)
        .request()
        .accept(APPLICATION_JSON)
        .post(json(kunde));
		
		assertThat(response.getStatus()).isEqualTo(HTTP_BAD_REQUEST);
		assertThat(response.getHeaderString("validation-exception")).isEqualTo("true");
		final ViolationReport violationReport = response.readEntity(ViolationReport.class);
		response.close();

		final List<ResteasyConstraintViolation> violations = violationReport.getParameterViolations();
		assertThat(violations).isNotEmpty();

		ResteasyConstraintViolation violation =
				                    filter(violations).with("message")
		                                              .equalsTo("Eine PLZ muss eine 5-stellige Zahl sein.")
		                                              .get()
		                                              .iterator()
		                                              .next();
		assertThat(violation.getValue()).isEqualTo(String.valueOf(NEUE_PLZ_FALSCH));
		
		LOGGER.finer("ENDE");
		
	}
	
}
