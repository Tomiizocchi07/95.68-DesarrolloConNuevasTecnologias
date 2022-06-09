package com.fiuba.VentaDeuda.Domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "comprador")
@Data
public class RolComprador extends Rol {

    @OneToMany
    private List<Deuda> deudasCompradas;
}
