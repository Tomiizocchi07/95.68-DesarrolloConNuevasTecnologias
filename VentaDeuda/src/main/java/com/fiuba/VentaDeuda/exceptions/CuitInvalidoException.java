package com.fiuba.VentaDeuda.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CuitInvalidoException extends RuntimeException{

    public CuitInvalidoException (String mensaje) { super(mensaje);}
}