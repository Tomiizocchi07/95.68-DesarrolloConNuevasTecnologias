package com.fiuba.VentaDeuda.Domain;

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
    private String userName;

    @NotNull
    private String password;

    @NotNull
    private String cuit;

    @OneToMany
    private List<Rol> rol;

    @OneToMany
    private List<Nivel> nivel;
}
