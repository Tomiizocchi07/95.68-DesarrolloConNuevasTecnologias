package com.fiuba.VentaDeuda.service.serviceImpl;

import com.fiuba.VentaDeuda.dao.UsuarioDAO;
import com.fiuba.VentaDeuda.domain.Deuda;
import com.fiuba.VentaDeuda.domain.Usuario;
import com.fiuba.VentaDeuda.dto.usuario.SaldoUsuarioRequest;
import com.fiuba.VentaDeuda.exceptions.CuitInvalidoException;
import com.fiuba.VentaDeuda.exceptions.ExceptionMessage;
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
    public Usuario crearUsuario(Usuario usuario){
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        if(!usuario.isValidCUITCUIL(usuario.getCuit())){
            throw new CuitInvalidoException(ExceptionMessage.CUIT_NO_VALIDO.getValue());
        };
        return(usuarioDAO.save(usuario));
    }

    @Override
    public Usuario guardar(Usuario usuario) {
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

