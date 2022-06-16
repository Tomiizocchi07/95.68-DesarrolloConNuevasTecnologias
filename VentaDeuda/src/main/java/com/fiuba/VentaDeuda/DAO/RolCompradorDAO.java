package com.fiuba.VentaDeuda.DAO;

import com.fiuba.VentaDeuda.Domain.Deuda;
import com.fiuba.VentaDeuda.Domain.RolComprador;
import com.fiuba.VentaDeuda.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolCompradorDAO extends JpaRepository<RolComprador,Long> {
}
