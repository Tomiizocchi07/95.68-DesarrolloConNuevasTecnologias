package com.fiuba.VentaDeuda.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "rol")
@Entity
@Data
public abstract class Rol {

    @ManyToOne
    @Id
    private Usuario usuario;
}
