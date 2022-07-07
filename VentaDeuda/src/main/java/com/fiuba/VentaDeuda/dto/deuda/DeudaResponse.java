package com.fiuba.VentaDeuda.dto.deuda;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fiuba.VentaDeuda.domain.Usuario;
import com.fiuba.VentaDeuda.enums.EstadoDeuda;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.util.Date;

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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date emision;
    private String descripcion;
}
