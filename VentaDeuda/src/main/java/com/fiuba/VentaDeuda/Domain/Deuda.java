package com.fiuba.VentaDeuda.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(name = "deuda")
@Data
public class Deuda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idDeuda;

    @NotNull
    private BigInteger valor;

    @ManyToOne
    private RolComprador comprador;

    @ManyToOne
    private RolVendedor vendedor;

    @NotNull
    private BigInteger precio;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaCreacion;

    //Si la deuda esta vendida, su estado será true.
    private boolean estado;

    private String descripcion;
}
