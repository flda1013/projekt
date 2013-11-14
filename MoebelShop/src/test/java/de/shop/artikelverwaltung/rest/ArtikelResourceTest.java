package de.shop.artikelverwaltung.rest;

import static de.shop.util.TestConstants.ARTIKEL_ID_URI;
import static de.shop.util.TestConstants.ARTIKEL_URI;
import static de.shop.util.TestConstants.ARTIKEL_ID_PATH_PARAM;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static de.shop.util.TestConstants.ARTIKEL_ID_NICHT_VORHANDEN;
import static de.shop.util.TestConstants.ARTIKEL_ID_VORHANDEN;
import static de.shop.util.TestConstants.PASSWORD_ADMIN;
import static de.shop.util.TestConstants.USERNAME_ADMIN;
import static de.shop.util.TestConstants.ARTIKEL_BEZEICHNUNG;
import static de.shop.util.TestConstants.ARTIKEL_PREIS;
import static de.shop.util.TestConstants.PASSWORD_FALSCH;
import static org.fest.assertions.api.Assertions.assertThat;
import static javax.ws.rs.client.Entity.json;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.junit.Test;
import org.junit.runner.RunWith;






import javax.ws.rs.core.Response;

import de.shop.util.AbstractResourceTest;
import de.shop.artikelverwaltung.domain.Artikel;
import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_OK;



import static java.net.HttpURLConnection.HTTP_UNAUTHORIZED;
import static java.util.Locale.ENGLISH;

import java.lang.invoke.MethodHandles;
import java.util.logging.Logger;



@RunWith(Arquillian.class)
public class ArtikelResourceTest extends AbstractResourceTest {
	
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());
	final Long artikelID = Long.valueOf(ARTIKEL_ID_VORHANDEN);
	final Long artikelIDN = Long.valueOf(ARTIKEL_ID_NICHT_VORHANDEN);
	

@Test
@InSequence(1)
public void findArtikelByIDVorhanden()
{
	LOGGER.finer("BEGINN");
		
	final Response response = getHttpsClient().target(ARTIKEL_ID_URI)
            .resolveTemplate(ARTIKEL_ID_PATH_PARAM, artikelID)
            .request()
            .accept(APPLICATION_JSON)
            .get();
	


	
	assertThat(response.getStatus()).isEqualTo(HTTP_OK);
	final Artikel artikel = response.readEntity(Artikel.class);
	
	assertThat(artikel.getId()).isEqualTo(artikelID);


	LOGGER.finer("ENDE");
}


@Test
@InSequence(2)
public void findArtikelByIDNichtVorhanden()
{
	LOGGER.finer("BEGINN");
	
	final Response response = getHttpsClient().target(ARTIKEL_ID_URI)
            .resolveTemplate(ARTIKEL_ID_PATH_PARAM, artikelIDN)
            .request()
            .accept(APPLICATION_JSON)
            .get();
	


	
	assertThat(response.getStatus()).isEqualTo(HTTP_NOT_FOUND);
	final String fehlermeldung = response.readEntity(String.class);
	assertThat(fehlermeldung).startsWith("Kein Artikel mit der ID")
	                         .endsWith("gefunden.");
	



	LOGGER.finer("ENDE");
}
	
@Test
@InSequence(3)
public void CreateArtikelMitAnmeldung()
{
	LOGGER.finer("BEGINN");
	
	final Artikel artikel = new Artikel();
	artikel.setBezeichnung(ARTIKEL_BEZEICHNUNG);
	artikel.setPreis(ARTIKEL_PREIS);

	
	final Response response = getHttpsClient(USERNAME_ADMIN, PASSWORD_ADMIN).target(ARTIKEL_URI)
            .request()
            .accept(APPLICATION_JSON)
            // engl. Fehlermeldungen ohne Umlaute ;-)
            .acceptLanguage(ENGLISH)
            .post(json(artikel));
	
	
	assertThat(response.getStatus()).isEqualTo(HTTP_CREATED);
	response.close();
	LOGGER.finer("ENDE");
	
}

@Test
@InSequence(4)
public void CreateArtikelFalscheAnmeldung()
{
	LOGGER.finer("BEGINN");
	
	final Artikel artikel = new Artikel();
	artikel.setBezeichnung(ARTIKEL_BEZEICHNUNG);
	artikel.setPreis(ARTIKEL_PREIS);
	
	final Response response = getHttpsClient(USERNAME_ADMIN, PASSWORD_FALSCH).target(ARTIKEL_URI)
            .request()
            .accept(APPLICATION_JSON)
            .post(json(artikel));
	
    assertThat(response.getStatus()).isEqualTo(HTTP_UNAUTHORIZED);
    response.close();

LOGGER.finer("ENDE");

}
}
	

	
	
