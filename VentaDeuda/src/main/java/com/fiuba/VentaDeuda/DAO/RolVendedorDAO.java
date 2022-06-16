package com.fiuba.VentaDeuda.DAO;

import com.fiuba.VentaDeuda.Domain.Deuda;
import com.fiuba.VentaDeuda.Domain.RolVendedor;
import com.fiuba.VentaDeuda.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolVendedorDAO extends JpaRepository<RolVendedor,Long> {
}
