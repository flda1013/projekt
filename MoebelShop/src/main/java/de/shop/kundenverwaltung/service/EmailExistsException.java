package de.shop.kundenverwaltung.service;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class EmailExistsException extends AbstractKundeServiceException {
	private static final long serialVersionUID = 4867667611097919943L;
	private final String email;
	private static final String MESSAGE_KEY = "kunde.EmailExists";
	
	public EmailExistsException(String email) {
		super("Die Email-Adresse " + email + " existiert bereits");
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getMessageKey() {
	
		return MESSAGE_KEY;
	}
}
