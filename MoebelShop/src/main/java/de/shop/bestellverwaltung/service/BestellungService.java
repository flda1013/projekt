package de.shop.bestellverwaltung.service;

import java.util.List;
import java.util.Locale;

import de.shop.artikelverwaltung.domain.Artikel;
import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.bestellverwaltung.domain.Lieferung;
import de.shop.kundenverwaltung.domain.AbstractKunde;

public interface BestellungService {

	Bestellung findBestellungById(Long id);
	Bestellung findBestellungByIdMitLieferungen(Long id);
	AbstractKunde findKundeById(Long id);
	List<Bestellung> findBestellungenByKunde(AbstractKunde kunde);
	Bestellung createBestellung(Bestellung bestellung, Long kundeId, Locale locale);
	Bestellung createBestellung(Bestellung bestellung, AbstractKunde kunde, Locale locale);
	List<Artikel> ladenhueter(int anzahl);
	List<Lieferung> findLieferungen(String nr);
	Lieferung createLieferung(Lieferung lieferung, List<Bestellung> bestellungen);
}


/*package de.shop.bestellverwaltung.service;


import java.io.Serializable;
import java.lang.invoke.MethodHandles;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import de.shop.bestellverwaltung.domain.Bestellung;

public class BestellungService implements Serializable {	
	private static final long serialVersionUID = -30765030092242363L;
	private static final Logger LOGGER = Logger.getLogger(MethodHandles.lookup().lookupClass());
	
	@PersistenceContext
	private transient EntityManager em;
	
	@PostConstruct
	private void postConstruct() {
		LOGGER.debugf("CDI-faehiges Bean %s wurde erzeugt", this);
	}
	
	@PreDestroy
	private void preDestroy() {
		LOGGER.debugf("CDI-faehiges Bean %s wird geloescht", this);
	}
	
	public Bestellung findBestellungById(Long id) {
		final Bestellung bestellung = em.find(Bestellung.class, id);
		return bestellung;
	}

}*/
