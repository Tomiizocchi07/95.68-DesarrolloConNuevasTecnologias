package com.fiuba.VentaDeuda.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class RolComprador extends Rol{

    @OneToMany
    private List<Deuda> deudasCompradas;

    public void agregarCompra(Deuda deuda){
        deudasCompradas.add(deuda);
    }
}