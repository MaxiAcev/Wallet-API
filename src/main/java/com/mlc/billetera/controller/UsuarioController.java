package com.mlc.billetera.controller;

import com.mlc.billetera.model.Usuario;
import com.mlc.billetera.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return usuarioService.obtenerTodos();
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return usuarioService.guardarUsuario(usuario);
    }
}
