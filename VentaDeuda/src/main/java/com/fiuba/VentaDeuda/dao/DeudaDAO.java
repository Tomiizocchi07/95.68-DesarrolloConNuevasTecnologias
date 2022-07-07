package com.fiuba.VentaDeuda.dao;

import com.fiuba.VentaDeuda.domain.Deuda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeudaDAO extends JpaRepository<Deuda,Long> {
}
