package com.fiuba.VentaDeuda.DTO.Deuda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeudaRequest {

    @NotNull
    @NotBlank
    private Long idDeuda;

    private BigInteger monto;

    private BigInteger costo;

    private String descripcion;
}
