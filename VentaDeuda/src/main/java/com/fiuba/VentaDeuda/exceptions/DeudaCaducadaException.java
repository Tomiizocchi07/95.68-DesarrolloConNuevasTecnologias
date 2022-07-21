package com.fiuba.VentaDeuda.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DeudaCaducadaException extends RuntimeException{

    public DeudaCaducadaException (String mensaje) { super(mensaje);}
}
