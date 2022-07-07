package com.fiuba.VentaDeuda.domain;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fiuba.VentaDeuda.enums.EstadoDeuda;
import lombok.Data;
import org.springframework.cglib.core.Local;
import org.springframework.cglib.core.internal.LoadingCache;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "deuda")
@Data
public class Deuda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //El valor es el monto total de la deuda a cobrar. Es la cantidad que debe cobrar el usuario que compra la deuda.
    @NotNull
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn
    private Usuario comprador;

    @ManyToOne
    @JoinColumn
    private Usuario vendedor;

    //El precio es el monto por el cual la deuda es vendida. Representa una fraccion del valor.
    @NotNull
    private BigDecimal precio;

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
