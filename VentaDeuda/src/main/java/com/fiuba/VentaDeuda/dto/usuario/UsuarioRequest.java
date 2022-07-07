package com.fiuba.VentaDeuda.dto.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioRequest {

    private String userName;

    private String password;

    private String email;

    private String cuit;

}
