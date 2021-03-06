package de.shop.kundenverwaltung.domain;

import static de.shop.kundenverwaltung.domain.AbstractKunde.FIRMENKUNDE;
import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Cacheable
@DiscriminatorValue(FIRMENKUNDE)
public class Firmenkunde extends AbstractKunde {
	private static final long serialVersionUID = 3224665468219250145L;
}
