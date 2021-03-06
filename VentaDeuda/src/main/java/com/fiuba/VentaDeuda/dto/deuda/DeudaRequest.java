package com.fiuba.VentaDeuda.dto.deuda;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeudaRequest {

    private BigInteger valor;

    private BigInteger precio;

    private String descripcion;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate emision;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicacion = LocalDate.now();
}
