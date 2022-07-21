package com.fiuba.VentaDeuda.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DeudaNoDisponibleException extends RuntimeException{

    public DeudaNoDisponibleException (String mensaje) { super(mensaje);}
}
