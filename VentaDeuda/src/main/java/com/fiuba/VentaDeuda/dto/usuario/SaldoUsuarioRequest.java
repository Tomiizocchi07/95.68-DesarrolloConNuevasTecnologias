package com.fiuba.VentaDeuda.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaldoUsuarioRequest {

    private String userName;

    private int saldo;

}