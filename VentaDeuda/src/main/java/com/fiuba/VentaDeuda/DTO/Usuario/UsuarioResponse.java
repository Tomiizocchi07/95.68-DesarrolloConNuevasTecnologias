package com.fiuba.VentaDeuda.DTO.Usuario;

import com.fiuba.VentaDeuda.Domain.Deuda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioResponse {

    private String userName;

    private String email;

    private String cuit;

    private int saldo;
}
