package com.grindServer.grindServer.ejercicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EjercicioService {

	private final EjercicioRepository ejercicioRepository;

	@Autowired
	public EjercicioService(EjercicioRepository ejercicioRepository) {
		this.ejercicioRepository = ejercicioRepository;
	}

	public List<Ejercicio> getEjercicios() {
		return ejercicioRepository.findAll();
	}

	public void addEjercicio(Ejercicio ejercicio) {
		ejercicioRepository.save(ejercicio);
	}

	public void deleteEjercicio(Long id) {
		ejercicioRepository.existsById(id);
		ejercicioRepository.deleteById(id);
	}

	@Transactional
	public void updateEjercicio(Long id, String nombre, String img) {

		Ejercicio ejercicio = ejercicioRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Ejercicio con id " + id + ", no encontrado"));

		if (nombre != null &&
				nombre.length() > 0) {
			ejercicio.setNombre(nombre);
		}

		if (img != null &&
				img.length() > 0) {
			ejercicio.setImg(img);
		}

	}

}
