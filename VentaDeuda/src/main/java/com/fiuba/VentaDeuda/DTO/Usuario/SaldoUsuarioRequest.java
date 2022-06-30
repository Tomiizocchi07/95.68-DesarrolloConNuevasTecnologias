package com.fiuba.VentaDeuda.DTO.Usuario;

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