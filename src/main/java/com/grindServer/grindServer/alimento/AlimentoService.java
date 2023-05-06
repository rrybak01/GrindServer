package com.grindServer.grindServer.alimento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlimentoService {

	private final AlimentoRespository alimentoRepository;

	@Autowired
	public AlimentoService(AlimentoRespository alimentoRepository) {
		this.alimentoRepository = alimentoRepository;
	}

	public List<Alimento> getAlimentos() {
		return alimentoRepository.findAll();
	}

	public void addAlimento(Alimento alimento) {
		alimentoRepository.save(alimento);
	}

	public void deleteAlimento(Long id) {
		alimentoRepository.deleteById(id);
	}

	@Transactional
	public void updateAlimento(Long id, String nombre, Integer proteinas, Integer hidratos, Integer grasas) {

		Alimento alimento = alimentoRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Alimento con id " + id + ", no encontrado"));

		if (nombre != null &&
				nombre.length() > 0) {
					alimento.setNombre(nombre);
		}

		if (proteinas != null && 
		proteinas > 0) {
			alimento.setProteinas(proteinas);
		}

		if (hidratos != null &&
		hidratos > 0) {
			alimento.setHidratos(hidratos);
		}

		if (grasas != null && 
		grasas > 0) {
			alimento.setGrasas(grasas);
		}

	}

}
