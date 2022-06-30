package com.fiuba.VentaDeuda.Service.ServiceIMPL;

import com.fiuba.VentaDeuda.DAO.DeudaDAO;
import com.fiuba.VentaDeuda.Domain.Deuda;
import com.fiuba.VentaDeuda.Service.DeudaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeudaServiceIMPL implements DeudaService {

    @Autowired
    private DeudaDAO deudaDAO;

    @Override
    @Transactional
    public Deuda guardar(Deuda deuda) {
        return (deudaDAO.save(deuda));
    }

    @Override
    public Deuda encontrarDeuda(Long idDeuda) {
        return(deudaDAO.findById(idDeuda).orElse(null));
    }

    @Override
    public List<Deuda> listarDeudasDisponibles() {
        List<Deuda> deudas = deudaDAO.findAll();
        List<Deuda> deudasDisponibles = new ArrayList<>();
        for (Deuda deuda: deudas){
            if(!deuda.isEstado()){
                deudasDisponibles.add(deuda);
            }
        }
        return deudasDisponibles;
    }

    @Override
    public List<Deuda> listarDeudas() {
        return(deudaDAO.findAll());
    }
}
