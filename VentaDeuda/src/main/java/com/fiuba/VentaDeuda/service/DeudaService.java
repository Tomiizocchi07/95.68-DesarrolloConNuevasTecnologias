package com.fiuba.VentaDeuda.service;

import com.fiuba.VentaDeuda.domain.Deuda;

import java.util.List;

public interface DeudaService {

    Deuda guardar(Deuda deuda);

    Deuda encontrarDeuda(Long id);

    List<Deuda> listarDeudasDisponibles();

    List<Deuda> listarDeudas ();
}
