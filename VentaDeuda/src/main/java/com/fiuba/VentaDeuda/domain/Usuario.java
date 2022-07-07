package com.fiuba.VentaDeuda.domain;

import com.fiuba.VentaDeuda.exceptions.ExceptionMessage;
import com.fiuba.VentaDeuda.exceptions.SaldoNegativoException;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;

    @NotNull
    @Column(name = "userName")
    private String userName;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "cuit")
    private String cuit;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @OneToMany(mappedBy = "comprador")
    private List<Deuda> compras;

    @OneToMany(mappedBy = "vendedor")
    private List<Deuda> ventas;

    public void realizarVenta(Deuda deuda){
        this.saldo = saldo.add(deuda.getPrecio());
    }

    public void crearDeuda(Deuda deuda){
        this.ventas.add(deuda);
    }

    public void realizarCompra(Deuda deuda){
        this.saldo = saldo.subtract(deuda.getPrecio());
        this.compras.add(deuda);
    }

    public void validarMonto(BigDecimal saldo){
        if( saldo.compareTo(new BigDecimal(0)) == -1 ){
            throw new SaldoNegativoException(ExceptionMessage.SALDO_NEGATIVO.getValue());
        }
    }
}
