package com.grindServer.grindServer.usuario;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario getUsuarioById(Long id) {
		return usuarioRepository.findUsuarioById(id);
	}

	public void addNewUsuario(Usuario usuario) {
		Optional<Usuario> usuarioByEmail = usuarioRepository.findUsuarioByEmail(usuario.getEmail());
		if (usuarioByEmail.isPresent()) {
			throw new IllegalStateException("Email ya registrado");
		} else {
			usuario.setCalorias("2500");
			usuario.setPeso("80");
			usuario.setBenchpress("120");
			usuario.setSquat("140");
			usuario.setDeadlift("180");
			usuarioRepository.save(usuario);
		}
	}

	public void deleteUsuario(Long idUsuario) {
		boolean exists = usuarioRepository.existsById(idUsuario);
		if (!exists) {
			throw new IllegalStateException("Usuario con id " + idUsuario + ", no existe");
		} else {
			usuarioRepository.deleteById(idUsuario);
		}
	}

	@Transactional
	public void updateUsuario(Long idUsuario, Usuario usuario ) {

		Usuario usuario2 = usuarioRepository.findById(idUsuario)
				.orElseThrow(() -> new IllegalStateException("Usuario con id " + idUsuario + ", no existe"));

				String nombre = usuario.getNombre();
				String email = usuario.getEmail();
				String contraseña = usuario.getContraseña();
				String peso = usuario.getPeso();
				String calorias = usuario.getCalorias();
				String benchpress = usuario.getBenchpress();
				String squat = usuario.getSquat();
				String deadlift = usuario.getDeadlift();

		if (nombre != null &&
				nombre.length() > 0 &&
				!Objects.equals(usuario2.getNombre(), nombre)) {
					usuario2.setNombre(nombre);
		}

		if (email != null &&
				email.length() > 0 &&
				!Objects.equals(usuario2.getEmail(), email)) {

			Optional<Usuario> usuarioByEmail = usuarioRepository.findUsuarioByEmail(usuario.getEmail());
			if (usuarioByEmail.isPresent()) {
				throw new IllegalStateException("Email ya registrado");
			} else {
				usuario2.setEmail(email);
			}

		}

		if (contraseña != null &&
		contraseña.length() > 0 &&
				!Objects.equals(usuario2.getContraseña(), contraseña)) {
					usuario2.setContraseña(contraseña);
		}

		if (peso != null &&
		peso.length() > 0 &&
				!Objects.equals(usuario2.getPeso(), peso)) {
					usuario2.setPeso(peso);
		}

		if (calorias != null &&
		calorias.length() > 0 &&
				!Objects.equals(usuario2.getCalorias(), calorias)) {
					usuario2.setCalorias(calorias);
		}

		if (benchpress != null &&
		benchpress.length() > 0 &&
				!Objects.equals(usuario2.getBenchpress(), benchpress)) {
					usuario2.setBenchpress(benchpress);
		}

		if (squat != null &&
		squat.length() > 0 &&
				!Objects.equals(usuario2.getSquat(), squat)) {
					usuario2.setSquat(squat);
		}

		if (deadlift != null &&
		deadlift.length() > 0 &&
				!Objects.equals(usuario2.getDeadlift(), deadlift)) {
					usuario2.setDeadlift(deadlift);
		}

		usuario2.setId(idUsuario);
		usuarioRepository.save(usuario2);

	}

}
