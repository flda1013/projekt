package de.shop.bestellverwaltung.service;



public class InvalidBestellungIdException extends AbstractBestellungServiceException {
	private static final long serialVersionUID = 8553323515940121536L;
	private final Long bestellungId;
	private static final String MESSAGE_KEY = "bestellung.notFound.id";
	
	public InvalidBestellungIdException(Long bestellungId) {
		super("Bestellung mit ID = " + bestellungId + "vorhanden.");
		this.bestellungId = bestellungId;
	}
		
	public Long getBestellungId() {
		return bestellungId;
	}
	@Override
	public String getMessageKey() {
		
		return MESSAGE_KEY;
	}
}
