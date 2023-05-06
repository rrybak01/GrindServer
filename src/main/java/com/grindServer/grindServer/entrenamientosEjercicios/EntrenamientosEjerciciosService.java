package com.grindServer.grindServer.entrenamientosEjercicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntrenamientosEjerciciosService {

    private final EntrenamientosEjerciciosRepository entrenamientosEjerciciosRepository;

	@Autowired
	public EntrenamientosEjerciciosService(EntrenamientosEjerciciosRepository entrenamientosEjerciciosRepository) {
		this.entrenamientosEjerciciosRepository = entrenamientosEjerciciosRepository;
    }

    public List<EntrenamientosEjercicios> getEntrenamientosEjercicios() {
		return entrenamientosEjerciciosRepository.findAll();
	}

	public void addEntrenamientosEjercicios(EntrenamientosEjercicios Entrenamiento) {
		entrenamientosEjerciciosRepository.save(Entrenamiento);
	}

	public void deleteEntrenamientosEjercicios(Long id) {
		entrenamientosEjerciciosRepository.deleteById(id);
	}

	public void deleteByEntrennamiento(Long id) {
		entrenamientosEjerciciosRepository.deleteByEntrenamiento(id);
	}
    
}
