package de.shop.artikelverwaltung.service;



public class InvalidArtikelIdException extends AbstractArtikelServiceException {
	private static final long serialVersionUID = 8553323515940121536L;
	private final Long artikelId;
	private static final String MESSAGE_KEY = "artikel.IdInvalid";
	
	public InvalidArtikelIdException(Long artikelId) {
		super("Artikel mit ID = " + artikelId + "vorhanden.");
		this.artikelId = artikelId;
	}
		
	public Long getArtikelId() {
		return artikelId;
	}
	@Override
	public String getMessageKey() {
		
		return MESSAGE_KEY;
	}
}
