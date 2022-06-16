package com.fiuba.VentaDeuda.Service;

import com.fiuba.VentaDeuda.Domain.Deuda;
import com.fiuba.VentaDeuda.Domain.RolComprador;

import java.util.List;

public interface RolCompradorService {

    RolComprador guardar(RolComprador comprador);

    RolComprador encontrarComprador(Long idComprador);

    List<RolComprador> listarCompras ();
}
