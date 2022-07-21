package com.fiuba.VentaDeuda.exceptions;

import lombok.Getter;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Getter
public enum ExceptionMessage {
    CUIT_NO_VALIDO("El CUIT proporcionado no es correcto."),
    COMPRA_INVALIDA("No se pudo realizar la compra. Intentelo nuevamente."),
    DATOS_INCORRECTOS("Los datos proporcionados no son correctos"),
    SALDO_NEGATIVO("No puede cargar saldo negativo"),
    DEUDA_CADUCADA("No puede publicar una deuda de hace más de dos años."),
    DEUDA_NO_DISPONIBLE("La deuda que intenta comprar no esta disponible.");

    ExceptionMessage(String message){value = message;}

    private final String value;
}
