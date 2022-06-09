package com.fiuba.VentaDeuda.DTO.Deuda;

import com.fiuba.VentaDeuda.Domain.RolComprador;
import com.fiuba.VentaDeuda.Domain.RolVendedor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigInteger;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeudaResponse {

    private long idDeuda;
    private BigInteger monto;
    private RolComprador idComprador;
    private RolVendedor idVendedor;
    private BigInteger costo;
    private LocalDate fechaCreacion;
    private boolean estado;
    private String descripcion;
}
