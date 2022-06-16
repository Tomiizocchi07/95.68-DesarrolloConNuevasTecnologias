package com.fiuba.VentaDeuda.Domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class RolComprador implements Serializable{

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @OneToMany
    private List<Deuda> deudasCompradas;

    public void agregarCompra(Deuda deuda){
        this.deudasCompradas.add(deuda);
    }
}
