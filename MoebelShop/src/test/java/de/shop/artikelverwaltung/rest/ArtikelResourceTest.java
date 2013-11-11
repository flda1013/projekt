package de.shop.artikelverwaltung.rest;

import static de.shop.util.TestConstants.ARTIKEL_ID_VORHANDEN;
import static de.shop.util.TestConstants.ARTIKEL_URI;
import static de.shop.util.TestConstants.ARTIKEL_ID_URI;
import static de.shop.util.TestConstants.ARTIKEL_ID_PATH_PARAM;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.fest.assertions.api.Assertions.assertThat;

import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.junit.Test;
import org.junit.runner.RunWith;


import javax.ws.rs.core.Response;

import de.shop.util.AbstractResourceTest;
import de.shop.artikelverwaltung.domain.Artikel;

import static java.net.HttpURLConnection.HTTP_OK;


import java.lang.invoke.MethodHandles;

import java.util.logging.Logger;



@RunWith(Arquillian.class)
public class ArtikelResourceTest extends AbstractResourceTest {
	
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

@Test
@InSequence(1)
public void findArtikelBeyIDVorhanden()
{
	final Long artikelId = ARTIKEL_ID_VORHANDEN;
	
	final Response response = getHttpsClient().target(ARTIKEL_URI)
            .resolveTemplate(ARTIKEL_ID_PATH_PARAM, artikelId)
            .request()
            .accept(APPLICATION_JSON)
            .get();
	


	
	assertThat(response.getStatus()).isEqualTo(HTTP_OK);
	final Artikel artikel = response.readEntity(Artikel.class);
	
	assertThat(artikel.getId()).isEqualTo(artikelId);


	LOGGER.finer("ENDE");
}
			
	
}
	
	
