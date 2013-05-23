package de.shop.artikelverwaltung.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import de.shop.artikelverwaltung.domain.Artikel;
import de.shop.util.IdGroup;
import de.shop.util.Log;
import de.shop.util.Mock;
import de.shop.util.ValidatorProvider;

@Log
public class ArtikelService implements Serializable {
	private static final long serialVersionUID = -5105686816948437276L;

	@Inject
	private ValidatorProvider validatorProvider;
	
	public Artikel findArtikelById(Long id) {
		// TODO Datenbanzugriffsschicht statt Mock
		return Mock.findArtikelById(id);
	}
	private void validateArtikelId(Long artikelId, Locale locale) {
		final Validator validator = validatorProvider.getValidator(locale);
		final Set<ConstraintViolation<Artikel>> violations = validator.validateValue(Artikel.class,
				                                                                           "id",
	                                                                           IdGroup.class);
		if (!violations.isEmpty())
			throw new InvalidArtikelIdException(artikelId, violations);
	
	}
	
	private void validateArtikel(Artikel artikel, Locale locale, Class<?>... groups) {
		// Werden alle Constraints beim Einfuegen gewahrt?
		final Validator validator = validatorProvider.getValidator(locale);
		
		final Set<ConstraintViolation<Artikel>> violations = validator.validate(artikel, groups);
		if (!violations.isEmpty()) {
			throw new InvalidArtikelException(artikel, violations);
		}
	}
	
	
	
	public Artikel updateArtikel(Artikel artikel, Locale locale) {
		if (artikel == null) {
			return null;
		}
		// Werden alle Constraints beim Modifizieren gewahrt?
		validateArtikel(artikel, locale, Default.class, IdGroup.class);

		// TODO Datenbanzugriffsschicht statt Mock
		Mock.updateArtikel(artikel);
		
		return artikel;
	}
	public Collection<Artikel> findAllArtikel() {
		
		final List<Artikel> artikelPlural = Mock.findAllArtikel();
		return artikelPlural;
		
	}
	public Collection<Artikel> findArtikelByBezeichnung(String bezeichnung,
			Locale locale) {
		
		final List<Artikel> artikelPlural = Mock.findArtikelByBezeichnung(bezeichnung);
		return artikelPlural;
	}
	public void deleteArtikel(Long artikelId, Locale locale) {
		validateArtikelId(artikelId, locale);
		final Artikel artikel = findArtikelById(artikelId);
		if (artikel == null) {
			return;
		}
		// TODO Datenbanzugriffsschicht statt Mock
		Mock.deleteArtikel(artikel);
	}
	public Artikel createArtikel(Artikel artikel, Locale locale) {
		
		if (artikel == null) {
			return artikel;
		}
		// Werden alle Constraints beim Einfuegen gewahrt?
		validateArtikel(artikel, locale, Default.class);

		artikel = Mock.createArtikel(artikel);

		return artikel;
	}
		
	
}
