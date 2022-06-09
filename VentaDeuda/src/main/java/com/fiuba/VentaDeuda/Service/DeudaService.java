package com.fiuba.VentaDeuda.Service;

import com.fiuba.VentaDeuda.DAO.UsuarioDAO;
import com.fiuba.VentaDeuda.Domain.Deuda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeudaService {

    void guardar(Deuda deuda);

    Deuda encontrarDeuda(Long idDeuda);

    List<Deuda> listarDeudas ();
}
