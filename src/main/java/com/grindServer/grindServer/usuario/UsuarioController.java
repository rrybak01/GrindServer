package com.grindServer.grindServer.usuario;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "usuarios/")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
	public List<Usuario> getUsuarios(){
        return usuarioService.getUsuarios();
	}

    @GetMapping(path = "{id}")
	public Usuario getUsuarioById(@PathVariable Long id){
        return usuarioService.getUsuarioById(id);
	}
    
    @PostMapping
    public void registerNewUsuario(@RequestBody Usuario usuario){
        usuarioService.addNewUsuario(usuario);
    }

    @DeleteMapping(path = "{usuarioId}")
	public void deleteUsuario(@PathVariable("usuarioId") Long idUsuario){
		usuarioService.deleteUsuario(idUsuario);
	}

    @PutMapping(path = "{usuarioId}")
    public void updateUsuario(
        @PathVariable("usuarioId") Long idUsuario,
        @RequestBody(required = false) Usuario usuario){
            usuarioService.updateUsuario(idUsuario, usuario);
    }

}
