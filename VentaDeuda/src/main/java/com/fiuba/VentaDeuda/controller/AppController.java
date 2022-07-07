package com.fiuba.VentaDeuda.controller;

import com.fiuba.VentaDeuda.dto.deuda.DeudaRequest;
import com.fiuba.VentaDeuda.dto.usuario.UsuarioRequest;
import com.fiuba.VentaDeuda.dto.usuario.UsuarioResponse;
import com.fiuba.VentaDeuda.domain.*;
import com.fiuba.VentaDeuda.enums.EstadoDeuda;
import com.fiuba.VentaDeuda.service.DeudaService;
import com.fiuba.VentaDeuda.service.UsuarioService;
import com.fiuba.VentaDeuda.common.EntityDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AppController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DeudaService deudaService;

    @Autowired
    private EntityDTOConverter entityDTOConverter;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/auth/login")
    public String login (Model model){
        model.addAttribute("usuario", new UsuarioResponse());
        return "login";
    }

    @GetMapping("/deuda/crear")
    public String crearDeuda(Model model){
        model.addAttribute("deuda", new DeudaRequest());
        return "nuevaDeuda";
    }

    @PostMapping("/deuda/crear")
    public String formCrearDeuda(@Valid @ModelAttribute DeudaRequest deudaRequest, Authentication auth, BindingResult result, Model model){
        if(result.hasErrors()){
            System.out.println(result);
            return"redirect:/deuda/crear";
        }
        else{
            Deuda deuda = entityDTOConverter.convertDTOToDeuda(deudaRequest);
            Usuario usuario = usuarioService.findByUserName(auth.getName());
            deuda.crearDeuda(usuario);
            usuario.realizarVenta(deuda);
            model.addAttribute("deuda",deudaService.guardar(deuda));
        }
        return "redirect:/deuda/listado";
    }

    @GetMapping("/auth/registro")
    public String registroForm(Model model){
        model.addAttribute("usuario", new UsuarioRequest());
        return "registro";
    }

    @PostMapping("/auth/registro")
    public String registro(@Valid @ModelAttribute UsuarioRequest usuarioRequest, BindingResult result, Model model){
        if(result.hasErrors()){
            return"redirect:/registro";
        }
        else{
            Usuario usuario = entityDTOConverter.convertDTOToUsuario(usuarioRequest);
            model.addAttribute("usuario",usuarioService.guardar(usuario));
        }
        return "redirect:/auth/login";
    }

    @GetMapping("/usuario")
    public String mostrarPerfil(Authentication auth, Model model){
        Usuario usuario = usuarioService.findByUserName(auth.getName());
        model.addAttribute("usuario", entityDTOConverter.convertUsuarioToDTO(usuario));
        return "profile";
    }

    @GetMapping("/usuario/compras")
    public String mostrarCompras(Authentication auth, Model model){
        Usuario usuario = usuarioService.findByUserName(auth.getName());
        model.addAttribute("compras",usuario.getCompras());
        return "compras";
    }

    @GetMapping("/usuario/ventas")
    public String mostrarVentas(Authentication auth, Model model){
        Usuario usuario = usuarioService.findByUserName(auth.getName());
        model.addAttribute("ventas",usuario.getVentas());
        return "ventas";
    }

    @GetMapping("/deuda/listado")
    public String deudas(Model model){
        model.addAttribute("deudas", deudaService.listarDeudasDisponibles());
        return "deudas";
    }

    @GetMapping("/deuda/comprar/{idDeuda}")
    public String comprarDeuda(@PathVariable long idDeuda, Authentication auth){
        Usuario usuario = usuarioService.findByUserName(auth.getName());
        Deuda deuda = deudaService.encontrarDeuda(idDeuda);
        usuario.realizarCompra(deuda);
        deuda.realizarVenta(usuario);
        usuarioService.guardar(usuario);
        deudaService.guardar(deuda);
        return "redirect:/deuda/listado";
    }

    @GetMapping("/usuario/actualizar")
    public String cargarSaldo(Authentication auth, Model model){
        model.addAttribute("usuario", usuarioService.findByUserName(auth.getName()));
        return "cargarSaldo";
    }

    @GetMapping("/usuario/actualizar/saldo")
    public String cargarSaldoAUsuario(@RequestParam int saldo, Authentication auth){
        Usuario usuario = usuarioService.findByUserName(auth.getName());
        usuario.validarMonto(saldo);
        usuario.setSaldo(saldo);
        usuarioService.guardar(usuario);
        return "redirect:/usuario";
    }

}
