package com.fiuba.VentaDeuda.Domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class RolVendedor extends Rol {

    @OneToMany
    private List<Deuda> deudasVendidas;
}
