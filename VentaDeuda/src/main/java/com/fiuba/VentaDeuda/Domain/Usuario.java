package com.fiuba.VentaDeuda.Domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUsuario;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String cuit;

    @OneToMany
    private List<Deuda> deudas;
}
