package com.fiuba.VentaDeuda.domain;

import com.fiuba.VentaDeuda.enums.EstadoDeuda;
import com.fiuba.VentaDeuda.exceptions.DeudaCaducadaException;
import com.fiuba.VentaDeuda.exceptions.DeudaNoDisponibleException;
import com.fiuba.VentaDeuda.exceptions.ExceptionMessage;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.*;

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
    private LocalDate emision;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate publicacion;

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

    public void comprobarCaducidad(){
        if (DAYS.between(this.getEmision(), LocalDate.now()) > 7){
            this.setEstado(EstadoDeuda.VENCIDA);
        }
    }

    public void comprobarExpiracion(){
        if(YEARS.between(this.getPublicacion(), LocalDate.now()) >= 2){
            throw new DeudaCaducadaException(ExceptionMessage.DEUDA_CADUCADA.getValue());
        }
    }

    public void comprobarDisponibilidad(){
        if(!(this.getEstado() == EstadoDeuda.NO_VENDIDO)){
            throw new DeudaNoDisponibleException(ExceptionMessage.DEUDA_NO_DISPONIBLE.getValue());
        }
    }

}
