package com.fiuba.VentaDeuda.Controller;

import com.fiuba.VentaDeuda.DTO.Deuda.DeudaRequest;
import com.fiuba.VentaDeuda.DTO.Usuario.UsuarioRequest;
import com.fiuba.VentaDeuda.Domain.*;
import com.fiuba.VentaDeuda.Service.DeudaService;
import com.fiuba.VentaDeuda.Service.RolCompradorService;
import com.fiuba.VentaDeuda.Service.RolVendedorService;
import com.fiuba.VentaDeuda.Service.UsuarioService;
import com.fiuba.VentaDeuda.common.EntityDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Path;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolCompradorService compradorService;

    @Autowired
    private RolVendedorService vendedorService;

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
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @GetMapping("/auth/registro")
    public String registroForm(Model model){
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @PostMapping("/auth/registro")
    public String registro(@Valid @ModelAttribute UsuarioRequest usuarioRequest, BindingResult result, Model model){
        if(result.hasErrors()){
            return"redirect:/registro";
        }
        else{
            Usuario usuario = entityDTOConverter.convertDTOToUsuario(usuarioRequest);
            RolComprador comprador = new RolComprador();
            comprador.setUsuario(usuario);
            RolVendedor vendedor = new RolVendedor();
            vendedor.setUsuario(usuario);
            usuario.setCompras(comprador);
            usuario.setVentas(vendedor);

            model.addAttribute("usuario",usuarioService.guardar(usuario));
        }
        return "redirect:/auth/login";
    }

    @GetMapping("/usuario")
    public String mostrarPerfil(Authentication auth, Model model){
        Usuario usuario = usuarioService.findByUserName(auth.getName());
        model.addAttribute("usuario", usuario);
        model.addAttribute("ventas",usuario.getVentas());
        model.addAttribute("compras",usuario.getCompras());
        return "profile";
    }

    @GetMapping("/deuda/listado")
    public String deudas(Model model){
        model.addAttribute("deudas", deudaService.listarDeudas());

        return "deudas";
    }

    @GetMapping("/deuda/crear")
    public String deudaForm(Model model){
        model.addAttribute("deuda", new Deuda());
        return "nuevaDeuda";
    }

    @PostMapping("/deuda/guardar")
    public String registroDeuda(@Valid DeudaRequest deudaRequest, Authentication auth, BindingResult result, Model model){
        if(result.hasErrors()){
            return"redirect:/deuda/crear";
        }
        else{
            Deuda deuda = entityDTOConverter.convertDTOToDeuda(deudaRequest);
            deuda.setEstado(false);
            Usuario usuario = usuarioService.findByUserName(auth.getName());
            RolVendedor venta = usuario.getVentas();
            venta.setUsuario(usuario);
            venta.agregarVenta(deuda);
            deuda.setVendedor(venta);
            model.addAttribute("deuda",deudaService.guardar(deuda));
        }
        return "redirect:/deuda/listado";
    }

    @PutMapping("/deuda/comprar/{idDeuda}")
    public void comprarDeuda(@PathVariable Authentication auth, long idDeuda){
        Usuario usuario = usuarioService.findByUserName(auth.getName());
        Deuda deuda = deudaService.encontrarDeuda(idDeuda);
        RolComprador compra = usuario.getCompras();
        RolVendedor venta = usuario.getVentas();
        compra.setUsuario(usuario);
        compra.agregarCompra(deuda);
        deuda.setComprador(compra);
        venta.agregarVenta(deuda);
        venta.setUsuario(deuda.getVendedor().getUsuario());
    }

}
