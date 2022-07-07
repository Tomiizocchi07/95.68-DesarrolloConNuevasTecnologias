package com.fiuba.VentaDeuda.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioResponse {

    private String userName;

    private String email;

    private String cuit;

    private int saldo;
}
