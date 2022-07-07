package com.fiuba.VentaDeuda.service;

import com.fiuba.VentaDeuda.domain.Usuario;

public interface UsuarioService {

    Usuario guardar(Usuario usuario);

    Usuario encontrarUsuario(Long idUsuario);

    Usuario findByUserName(String userName);


}
