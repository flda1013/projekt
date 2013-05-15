package de.shop.artikelverwaltung.service;

import java.util.Collection;

import javax.validation.ConstraintViolation;

import de.shop.artikelverwaltung.domain.Artikel;


/**
 * Exception, die ausgel&ouml;st wird, wenn die Attributwerte eines Kunden nicht korrekt sind
 */
public class InvalidArtikelException extends ArtikelValidationException {
	
	private static final long serialVersionUID = 2428491133712963949L;
	private final Artikel artikel;
	
	public InvalidArtikelException(Artikel artikel,
			                     Collection<ConstraintViolation<Artikel>> violations) {
		super(violations);
		this.artikel = artikel;
	}

	public Artikel getArtikel() {
		return artikel;
	}
}

