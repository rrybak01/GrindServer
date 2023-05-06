package com.grindServer.grindServer.ejercicio;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "ejercicios/")
public class EjercicioController {

    private final EjercicioService ejercicioService;

    @Autowired
    public EjercicioController(EjercicioService ejercicioService){
        this.ejercicioService = ejercicioService;
    }

    @GetMapping
	public List<Ejercicio> getEjercicios(){
        return ejercicioService.getEjercicios();
    }

    @PostMapping
    public void postEjercicio(@RequestBody Ejercicio ejercicio){
        ejercicioService.addEjercicio(ejercicio);
    }

    @DeleteMapping("{id}")
	public void deleteEjercicio(@PathVariable("id") Long id){
		ejercicioService.deleteEjercicio(id);
	}

    @PutMapping("{id}")
    public void updateEjercicio(
        @PathVariable("id") Long id,
        @RequestParam(required = false) String nombre,
        @RequestParam(required = false) String img){
            ejercicioService.updateEjercicio(id, nombre, img);
    }
    
}
