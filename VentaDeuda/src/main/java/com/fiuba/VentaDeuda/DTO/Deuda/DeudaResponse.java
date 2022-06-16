package com.fiuba.VentaDeuda.DTO.Deuda;

import com.fiuba.VentaDeuda.Domain.RolComprador;
import com.fiuba.VentaDeuda.Domain.RolVendedor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeudaResponse {

    private long idDeuda;
    private BigInteger valor;
    private RolComprador comprador;
    private RolVendedor vendedor;
    private BigInteger precio;
    private boolean estado;
    private String descripcion;
}
