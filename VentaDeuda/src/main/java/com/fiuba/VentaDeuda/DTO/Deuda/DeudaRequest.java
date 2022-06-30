package com.fiuba.VentaDeuda.DTO.Deuda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeudaRequest {

    private Long idDeuda;

    private BigInteger valor;

    private BigInteger precio;

    private String descripcion;
}
