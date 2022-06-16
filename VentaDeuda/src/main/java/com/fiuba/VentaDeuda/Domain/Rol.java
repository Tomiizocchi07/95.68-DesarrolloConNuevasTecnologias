package com.fiuba.VentaDeuda.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "rol")
@Entity
@Data
public abstract class Rol implements Serializable {

    @ManyToOne
    @Id
    private Usuario usuario;
}
