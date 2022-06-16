package com.fiuba.VentaDeuda.Domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class RolVendedor implements Serializable {

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @OneToMany
    private List<Deuda> deudasVendidas;

    public void agregarVenta(Deuda deuda){
        this.deudasVendidas.add(deuda);
    }
}
