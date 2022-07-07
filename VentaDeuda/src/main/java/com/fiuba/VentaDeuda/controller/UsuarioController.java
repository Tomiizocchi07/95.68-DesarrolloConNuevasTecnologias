package com.fiuba.VentaDeuda.controller;

import com.fiuba.VentaDeuda.dto.usuario.UsuarioRequest;
import com.fiuba.VentaDeuda.dto.usuario.UsuarioResponse;
import com.fiuba.VentaDeuda.domain.Usuario;
import com.fiuba.VentaDeuda.service.UsuarioService;
import com.fiuba.VentaDeuda.common.EntityDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EntityDTOConverter entityDTOConverter;

    @PostMapping("/usuario/guardar")
    public void GuardarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        Usuario usuario = entityDTOConverter.convertDTOToUsuario(usuarioRequest);
        usuarioService.guardar(usuario);
    }

    @GetMapping("/usuario/{idUsuario}")
    public UsuarioResponse encontrarUsuario(@PathVariable Long idUsuario){
        Usuario usuario = usuarioService.encontrarUsuario(idUsuario);
        return (entityDTOConverter.convertUsuarioToDTO(usuario));
    }
}
