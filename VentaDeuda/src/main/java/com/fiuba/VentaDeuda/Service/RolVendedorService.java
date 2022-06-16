package com.fiuba.VentaDeuda.Service;

import com.fiuba.VentaDeuda.Domain.Deuda;
import com.fiuba.VentaDeuda.Domain.RolVendedor;

import java.util.List;

public interface RolVendedorService {

    RolVendedor guardar(RolVendedor vendedor);

    RolVendedor encontrarVendedor(Long idVendedor);

    List<RolVendedor> listarVentas ();
}
