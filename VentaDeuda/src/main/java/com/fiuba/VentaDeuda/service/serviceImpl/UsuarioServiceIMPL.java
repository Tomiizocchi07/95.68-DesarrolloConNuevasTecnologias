package com.fiuba.VentaDeuda.service.serviceImpl;

import com.fiuba.VentaDeuda.dao.UsuarioDAO;
import com.fiuba.VentaDeuda.domain.Usuario;
import com.fiuba.VentaDeuda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UsuarioServiceIMPL implements UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Usuario guardar(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return(usuarioDAO.save(usuario));
    }

    @Override
    public Usuario encontrarUsuario(Long idUsuario) {
        return (usuarioDAO.findById(idUsuario).orElse(null));
    }

    @Override
    public Usuario findByUserName(String userName) {
        return(usuarioDAO.findByUserName(userName));
    }

}

