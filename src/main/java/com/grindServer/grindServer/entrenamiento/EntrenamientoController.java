package com.grindServer.grindServer.entrenamiento;
import java.util.List;
import java.util.Optional;

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
@RequestMapping(path = "entrenamientos/")
public class EntrenamientoController {

    @Autowired
    private EntrenamientoService entrenamientoService;

    @GetMapping
	public List<Entrenamiento> getEntrenamiento(){
        return entrenamientoService.getEntrenamientos();
    }

    @GetMapping("{id}")
	public Optional<Entrenamiento> getEntrenamientoById(@PathVariable("id") Long id){
        return entrenamientoService.getEntrenamientoById(id);
    }

    @GetMapping("lista/{id}")
	public List<Entrenamiento> getEntrenamientoByIdUsuario(@PathVariable("id") Long id){
        return entrenamientoService.getEntrenamientosByIdUsuario(id);
    }

    @GetMapping("lastid")
	public Integer getLastEntrenamiento(){
        return entrenamientoService.getLastId();
    }

    @PostMapping("{idusuario}")
    public Long postEntrenamiento(
        @PathVariable("idusuario") Long idusuario){
        return entrenamientoService.addEntrenamiento(idusuario);
    }

    @DeleteMapping("{id}")
	public void deleteEntrenamiento(@PathVariable("id") Long id){
		entrenamientoService.deleteEntrenamiento(id);
	}

    @PutMapping("{id}")
    public void updateEjercicio(
        @PathVariable("id") Long id,
        @RequestParam(required = false) String nombre,
        @RequestParam(required = false) Long ejercicioId){
            entrenamientoService.updateEntrenamiento(id, nombre, ejercicioId);
    }

}
