package com.grindServer.grindServer.entrenamientosEjercicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "entrenamientosejercicios/")
public class EntrenamientosEjerciciosController {

    private final EntrenamientosEjerciciosService entrenamientosEjericiciosService;

    @Autowired
    public EntrenamientosEjerciciosController(EntrenamientosEjerciciosService entrenamientosEjericiciosService){
        this.entrenamientosEjericiciosService = entrenamientosEjericiciosService;
    }
    
    @GetMapping
	public List<EntrenamientosEjercicios> getEntrenamientosEjercicios(){
        return entrenamientosEjericiciosService.getEntrenamientosEjercicios();
    }

    @PostMapping
    public void postEntrenamiento(@RequestBody EntrenamientosEjercicios ejercicio){
        entrenamientosEjericiciosService.addEntrenamientosEjercicios(ejercicio);
    }

    @DeleteMapping("{id}")
	public void deleteEntrenamiento(@PathVariable("id") Long id){
		entrenamientosEjericiciosService.deleteEntrenamientosEjercicios(id);
	}

}
