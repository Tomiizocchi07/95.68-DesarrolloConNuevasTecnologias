package com.fiuba.VentaDeuda.DTO.Deuda;

import com.fiuba.VentaDeuda.Domain.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeudaResponse {

    private long idDeuda;
    private BigInteger valor;
    private Usuario comprador;
    private Usuario vendedor;
    private BigInteger precio;
    private boolean estado;
    private String descripcion;
}
