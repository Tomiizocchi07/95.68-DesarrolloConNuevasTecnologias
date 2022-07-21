package com.fiuba.VentaDeuda.service.serviceImpl;

import com.fiuba.VentaDeuda.common.EntityDTOConverter;
import com.fiuba.VentaDeuda.dao.DeudaDAO;
import com.fiuba.VentaDeuda.domain.Deuda;
import com.fiuba.VentaDeuda.enums.EstadoDeuda;
import com.fiuba.VentaDeuda.service.DeudaService;
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
    public Deuda encontrarDeuda(Long id) {
        return(deudaDAO.findById(id).orElse(null));
    }

    @Override
    public List<Deuda> listarDeudasDisponibles() {
        List<Deuda> deudas = deudaDAO.findAll();
        List<Deuda> deudasDisponibles = new ArrayList<>();
        for (Deuda deuda: deudas){
            deuda.comprobarCaducidad();
            if(deuda.getEstado() == EstadoDeuda.NO_VENDIDO || deuda.getEstado() == EstadoDeuda.VENCIDA){
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
