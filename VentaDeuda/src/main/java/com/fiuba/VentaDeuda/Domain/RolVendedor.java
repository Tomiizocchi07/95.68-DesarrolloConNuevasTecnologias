package com.fiuba.VentaDeuda.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class RolVendedor extends Rol{

    @OneToMany
    private List<Deuda> deudasVendidas;

    public void agregarVenta(Deuda deuda){
        deudasVendidas.add(deuda);
    }
}
