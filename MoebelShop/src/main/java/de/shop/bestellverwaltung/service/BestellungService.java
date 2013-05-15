package de.shop.bestellverwaltung.service;

import java.util.Collection;
import java.util.List;
import java.util.Locale;

import de.shop.bestellverwaltung.domain.BestellPosition;
import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.kundenverwaltung.domain.AbstractKunde;

public interface BestellungService {
	Bestellung findBestellungById(Long id);
	List<Bestellung> findBestellungenByKundeId(Long kundeId);
	Bestellung createBestellung(Bestellung bestellung, AbstractKunde kunde, Locale locale);
	Bestellung createBestellung(Bestellung bestellung, Locale locale);
	Collection<BestellPosition> findBestellPositionenByBestellungId(
			Long bestellungId);
}
