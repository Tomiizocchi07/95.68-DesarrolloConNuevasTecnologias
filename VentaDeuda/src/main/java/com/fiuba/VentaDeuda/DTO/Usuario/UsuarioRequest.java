package com.fiuba.VentaDeuda.DTO.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioRequest {

    private String userName;

    private String password;

    private String cuit;

}
