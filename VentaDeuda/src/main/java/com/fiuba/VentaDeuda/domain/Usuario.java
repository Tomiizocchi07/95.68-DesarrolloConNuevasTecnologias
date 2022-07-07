package com.fiuba.VentaDeuda.domain;

import com.fiuba.VentaDeuda.exceptions.ExceptionMessage;
import com.fiuba.VentaDeuda.exceptions.SaldoNegativoException;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
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
    private int saldo;

    @OneToMany(mappedBy = "comprador")
    private List<Deuda> compras;

    @OneToMany(mappedBy = "vendedor")
    private List<Deuda> ventas;

    public void realizarVenta(Deuda deuda){
        this.ventas.add(deuda);
    }

    public void realizarCompra(Deuda deuda){
        this.compras.add(deuda);
    }

    public void validarMonto(int saldo){
        if( saldo < 0 ){
            throw new SaldoNegativoException(ExceptionMessage.SALDO_NEGATIVO.getValue());
        }
    }
}
