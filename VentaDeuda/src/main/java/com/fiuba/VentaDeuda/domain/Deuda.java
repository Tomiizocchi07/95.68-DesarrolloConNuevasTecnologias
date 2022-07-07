package com.fiuba.VentaDeuda.domain;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fiuba.VentaDeuda.enums.EstadoDeuda;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "deuda")
@Data
public class Deuda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private BigInteger valor;

    @ManyToOne
    @JoinColumn
    private Usuario comprador;

    @ManyToOne
    @JoinColumn
    private Usuario vendedor;

    @NotNull
    private BigInteger precio;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date emision;

    @NotNull
    private EstadoDeuda estado;

    private String descripcion;

    public void realizarVenta(Usuario usuario){
        this.setComprador(usuario);
        this.setEstado(EstadoDeuda.VENDIDO);
    }

    public void crearDeuda(Usuario usuario){
        this.setVendedor(usuario);
        this.setEstado(EstadoDeuda.NO_VENDIDO);
    }
}
