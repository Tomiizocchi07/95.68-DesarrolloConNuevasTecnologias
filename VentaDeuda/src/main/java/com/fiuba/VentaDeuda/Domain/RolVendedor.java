package com.fiuba.VentaDeuda.Domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vendedor")
@Data
public class RolVendedor extends Rol{

    @OneToMany
    private List<Deuda> deudasVendidas;
}
