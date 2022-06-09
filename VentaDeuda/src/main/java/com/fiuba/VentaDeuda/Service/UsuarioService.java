package com.fiuba.VentaDeuda.Service;

import com.fiuba.VentaDeuda.Domain.Usuario;

public interface UsuarioService {

    Usuario guardar(Usuario usuario);

    Usuario encontrarUsuario(Long idUsuario);

    Usuario findByUserName(String userName);


}
