package com.fiuba.VentaDeuda.Service;

import com.fiuba.VentaDeuda.Domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioService {

    void guardar(Usuario usuario);

    Usuario encontrarUsuario(Long idUsuario);


}
