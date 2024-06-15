package com.ecommerce.exception;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModeloNotFoundException extends Exception{

	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}
}

