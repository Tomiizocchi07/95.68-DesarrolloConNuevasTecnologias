package com.fiuba.VentaDeuda.DTO.Usuario;

import com.fiuba.VentaDeuda.Domain.RolComprador;
import com.fiuba.VentaDeuda.Domain.RolVendedor;
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

    private String email;

    private String cuit;

    private RolComprador rolComprador = new RolComprador();

    private RolVendedor rolVendedor = new RolVendedor();

}
