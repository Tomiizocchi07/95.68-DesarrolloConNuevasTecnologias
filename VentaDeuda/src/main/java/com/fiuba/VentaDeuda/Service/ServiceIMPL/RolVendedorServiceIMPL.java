package com.fiuba.VentaDeuda.Service.ServiceIMPL;

import com.fiuba.VentaDeuda.DAO.RolVendedorDAO;
import com.fiuba.VentaDeuda.Domain.Deuda;
import com.fiuba.VentaDeuda.Domain.RolComprador;
import com.fiuba.VentaDeuda.Domain.RolVendedor;
import com.fiuba.VentaDeuda.Service.RolVendedorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RolVendedorServiceIMPL implements RolVendedorService {

    @Autowired
    private RolVendedorDAO vendedorDAO;

    @Override
    public RolVendedor guardar(RolVendedor vendedor) {
        return (vendedorDAO.save(vendedor));
    }

    @Override
    public RolVendedor encontrarVendedor(Long idVendedor) {
        return (vendedorDAO.findById(idVendedor)).orElse(null);
    }

    @Override
    public List<RolVendedor> listarVentas() {
        return(vendedorDAO.findAll());
    }
}
