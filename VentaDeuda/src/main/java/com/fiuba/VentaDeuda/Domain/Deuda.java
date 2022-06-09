package com.fiuba.VentaDeuda.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(name = "deuda")
@Data
public class Deuda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDeuda;

    @NotNull
    private BigInteger monto;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    private BigInteger costo;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaCreacion;

    //Si la deuda esta vendida, su estado será true.
    private boolean estado;

    private String descripcion;
}
