package com.fiuba.VentaDeuda.Service.ServiceIMPL;

import com.fiuba.VentaDeuda.DAO.UsuarioDAO;
import com.fiuba.VentaDeuda.Domain.Nivel;
import com.fiuba.VentaDeuda.Domain.Usuario;
import com.fiuba.VentaDeuda.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

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

