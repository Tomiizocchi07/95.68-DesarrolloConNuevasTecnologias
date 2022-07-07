package com.fiuba.VentaDeuda.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaldoUsuarioRequest {

    private String userName;

    private BigDecimal saldo;

}