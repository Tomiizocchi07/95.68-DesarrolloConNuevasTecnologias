package com.fiuba.VentaDeuda.Service.ServiceIMPL;

import com.fiuba.VentaDeuda.DAO.UsuarioDAO;
import com.fiuba.VentaDeuda.Domain.Usuario;
import com.fiuba.VentaDeuda.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioServiceIMPL implements UsuarioService {

    @Autowired
    private UsuarioDAO usuarioService;


    @Override
    public void guardar(Usuario usuario) {
        usuarioService.save(usuario);
    }

    @Override
    public Usuario encontrarUsuario(Long idUsuario) {
        return(usuarioService.findById(idUsuario).orElse(null));
    }
}
