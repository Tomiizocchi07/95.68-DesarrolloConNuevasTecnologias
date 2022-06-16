package com.fiuba.VentaDeuda.Domain;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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

    @OneToOne
    private RolComprador compras;

    @OneToOne
    private RolVendedor ventas;

    @OneToMany
    @Column(name = "nivel")
    private List<Nivel> nivel;
}
