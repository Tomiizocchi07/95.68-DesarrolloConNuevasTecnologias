package com.fiuba.VentaDeuda.Service.ServiceIMPL;

import com.fiuba.VentaDeuda.DAO.DeudaDAO;
import com.fiuba.VentaDeuda.Domain.Deuda;
import com.fiuba.VentaDeuda.Service.DeudaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeudaServiceIMPL implements DeudaService {

    @Autowired
    private DeudaDAO deudaDAO;

    @Override
    @Transactional
    public void guardar(Deuda deuda) {
        deudaDAO.save(deuda);
    }

    @Override
    public Deuda encontrarDeuda(Long idDeuda) {
        return(deudaDAO.findById(idDeuda).orElse(null));
    }

    @Override
    public List<Deuda> listarDeudas() {
        return(deudaDAO.findAll());
    }
}
