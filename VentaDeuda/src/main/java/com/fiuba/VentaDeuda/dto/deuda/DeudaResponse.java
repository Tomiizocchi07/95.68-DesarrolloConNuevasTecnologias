package com.fiuba.VentaDeuda.dto.deuda;

import com.fiuba.VentaDeuda.domain.Usuario;
import com.fiuba.VentaDeuda.enums.EstadoDeuda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeudaResponse {

    private long id;
    private BigInteger valor;
    private Usuario comprador;
    private Usuario vendedor;
    private BigInteger precio;
    private EstadoDeuda estado;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate emision;
    private String descripcion;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicacion;
}
