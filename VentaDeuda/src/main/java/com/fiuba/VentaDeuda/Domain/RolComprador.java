package com.fiuba.VentaDeuda.Domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class RolComprador extends Rol{

    @OneToMany
    private List<Deuda> deudasCompradas;
}
