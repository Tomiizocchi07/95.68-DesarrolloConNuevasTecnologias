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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("userDetailsService")
public class UsuarioServiceIMPL implements UsuarioService, UserDetailsService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public void guardar(Usuario usuario) {
        usuarioDAO.save(usuario);
    }

    @Override
    public Usuario encontrarUsuario(Long idUsuario) {
        return (usuarioDAO.findById(idUsuario).orElse(null));
    }

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Usuario usuario = usuarioDAO.findByUserName(userName);

        if(usuario == null){
            throw new UsernameNotFoundException(userName);
        }

        ArrayList<GrantedAuthority> niveles = new ArrayList();

        for(Nivel nivel: usuario.getNivel()){
            niveles.add(new SimpleGrantedAuthority(nivel.getNombre()));
        }

        return new User(usuario.getUserName(), usuario.getPassword(), niveles);
    }
}

