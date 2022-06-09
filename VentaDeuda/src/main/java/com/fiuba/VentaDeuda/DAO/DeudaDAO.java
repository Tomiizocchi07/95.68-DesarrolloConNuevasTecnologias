package com.fiuba.VentaDeuda.DAO;

import com.fiuba.VentaDeuda.Domain.Deuda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeudaDAO extends JpaRepository<Deuda,Long> {
}
