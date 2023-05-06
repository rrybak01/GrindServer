package com.grindServer.grindServer.comidas;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grindServer.grindServer.alimentosComidas.AlimentosComidas;
import com.grindServer.grindServer.alimentosComidas.AlimentosComidasService;

@Service
public class ComidaService {

	@Autowired
	private ComidaRepository comidaRepository;

	@Autowired
	private AlimentosComidasService acservice;

	public List<Comida> getComidas() {
		return comidaRepository.findAll();
	}

	public List<Comida> getComidasByUserId(Long idUsuario) {
		Date date = new Date();
		return comidaRepository.findByIdUsuario(idUsuario, date);
	}

	public void addComida(List<Comida> comida, Long id) {

		Date date = new Date();
		List<Comida> comidasDate = comidaRepository.findByIdUsuario(id, date);
		/* boolean date = true;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(new Date());

		for (Comida comidaDateAux : comidasDate) {
			if (dateString.equals(formatter.format(comidaDateAux.getFecha()))) {
				date = false;
			}
		} */

		if (comidasDate.size() == 0) {
			for (Comida comidaAUx : comida) {
				comidaAUx.setFecha(new Date());
				comidaAUx.setIdUsuario(id);
				comidaRepository.save(comidaAUx);
			}
		} 

	}

	@Transactional
	public void updateComida(Long id, Long alimentoId) {

		Optional<Comida> comida = comidaRepository.findById(id);
		
		if (comida != null) {
			acservice.addAlimentosComidas(new AlimentosComidas(alimentoId, id));
		}


	}

}
