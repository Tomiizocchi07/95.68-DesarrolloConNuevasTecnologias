package com.fiuba.VentaDeuda.Service.ServiceIMPL;

import com.fiuba.VentaDeuda.DAO.RolCompradorDAO;
import com.fiuba.VentaDeuda.Domain.RolComprador;
import com.fiuba.VentaDeuda.Service.RolCompradorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RolCompradorServiceIMPL implements RolCompradorService {

    @Autowired
    private RolCompradorDAO compradorDAO;

    @Override
    public RolComprador guardar(RolComprador comprador) {
        return (compradorDAO.save(comprador));
    }

    @Override
    public RolComprador encontrarComprador(Long idComprador) {
        return (compradorDAO.findById(idComprador)).orElse(null);
    }

    @Override
    public List<RolComprador> listarCompras() {
        return compradorDAO.findAll();
    }
}
