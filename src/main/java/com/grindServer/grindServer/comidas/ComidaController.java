package com.grindServer.grindServer.comidas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "comidas/")
public class ComidaController {

    private final ComidaService comidaService;

    @Autowired
    public ComidaController(ComidaService comidaService) {
        this.comidaService = comidaService;
    }

    @GetMapping
    public List<Comida> getComidas() {
        return comidaService.getComidas();
    }

    @GetMapping("/{idUsuario}")
    public List<Comida> getComidasByUserId(@PathVariable long idUsuario) {
        return comidaService.getComidasByUserId(idUsuario);
    }

    @PostMapping("{id}")
    public void postComida(
            @PathVariable("id") Long id,
            @RequestBody List<Comida> comida) {
        comidaService.addComida(comida, id);
    }

    @PutMapping("{id}")
    public void updateComida(
            @PathVariable("id") Long id,
            @RequestParam(required = false) Long alimentoId) {
        comidaService.updateComida(id, alimentoId);
    }

}
