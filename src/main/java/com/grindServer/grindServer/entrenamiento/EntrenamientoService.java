package com.grindServer.grindServer.entrenamiento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grindServer.grindServer.entrenamientosEjercicios.EntrenamientosEjercicios;
import com.grindServer.grindServer.entrenamientosEjercicios.EntrenamientosEjerciciosService;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenamientoService {

	@Autowired
	private EntrenamientoRepository entrenamientoRepository;

	@Autowired
	private EntrenamientosEjerciciosService eeService;

	public List<Entrenamiento> getEntrenamientos() {
		return entrenamientoRepository.findEntrenamientos();
	}

	public Optional<Entrenamiento> getEntrenamientoById(Long id) {
		return entrenamientoRepository.findById(id);
	}

	public List<Entrenamiento> getEntrenamientosByIdUsuario(Long id) {
		return entrenamientoRepository.findByIdUsuario(id);
	}

	public Long addEntrenamiento(Long idusuario ) {
		Entrenamiento e = new Entrenamiento("Nombre entrenamiento", idusuario);
		entrenamientoRepository.save(e);
		return e.getId();
	}

	public void deleteEntrenamiento(Long id) {
		eeService.deleteByEntrennamiento(id);
		entrenamientoRepository.deleteById(id);
	}

	@Transactional
	public void updateEntrenamiento(Long id, String nombre, Long ejercicioId) {

		Entrenamiento entrenamiento = entrenamientoRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Ejercicio con id " + id + ", no encontrado"));

		if (entrenamiento != null) {
			if (nombre != null &&
					nombre.length() > 0) {
				entrenamiento.setNombre(nombre);
			}

			if (ejercicioId != null && id != null) {
				eeService.addEntrenamientosEjercicios(new EntrenamientosEjercicios(id, ejercicioId));
			}
		}

	}

	public int getLastId() {
		return entrenamientoRepository.findLastId();
	}

}
