package de.shop.artikelverwaltung.service;

import de.shop.util.AbstractShopException;

public class ArtikelServiceException extends AbstractShopException{

	private static final long serialVersionUID = 8138414196023007630L;

	public ArtikelServiceException(String msg) {
		super(msg);
	}
	
	public ArtikelServiceException(String msg, Throwable t) {
		super(msg, t);
	}
}
