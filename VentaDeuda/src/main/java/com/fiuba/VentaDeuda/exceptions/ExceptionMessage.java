package com.fiuba.VentaDeuda.exceptions;

import lombok.Getter;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Getter
public enum ExceptionMessage {
    CUIT_NO_VALIDO("El CUIT proporcionado no es correcto."),
    COMPRA_INVALIDA("No se pudo realizar la compra. Intentelo nuevamente."),
    DATOS_INCORRECTOS("Los datos proporcionados no son correctos");

    ExceptionMessage(String message){value = message;}

    private final String value;
}
