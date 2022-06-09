package com.fiuba.VentaDeuda.DAO;

import com.fiuba.VentaDeuda.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario,Long> {
    Usuario findByUserName(String userName);
}
