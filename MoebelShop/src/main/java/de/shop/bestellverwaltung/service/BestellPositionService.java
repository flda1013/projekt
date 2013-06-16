package de.shop.bestellverwaltung.service;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.shop.bestellverwaltung.domain.Bestellposition;


public class BestellPositionService implements Serializable {

	private static final long serialVersionUID = -2445565397989052361L;
	@PersistenceContext
	private transient EntityManager em;

	public Bestellposition findBestellPositionById(Long id) {
		// TODO Datenbanzugriffsschicht statt Mock
		return em.findBestellpositionById(id);
		
	}
	public Bestellposition createBestellPosition(Bestellposition bestellPosition) {
				
		return em.createBestellposition(bestellposition);
	}
}
