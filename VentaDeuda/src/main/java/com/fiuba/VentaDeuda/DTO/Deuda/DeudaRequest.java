package com.fiuba.VentaDeuda.DTO.Deuda;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeudaRequest {

    private BigInteger valor;

    private BigInteger precio;

    private String descripcion;

    private LocalDate fechaCreacion = LocalDate.now();
}
