package com.fiuba.VentaDeuda.dao;

import com.fiuba.VentaDeuda.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario,Long> {
    Usuario findByUserName(String userName);
}
