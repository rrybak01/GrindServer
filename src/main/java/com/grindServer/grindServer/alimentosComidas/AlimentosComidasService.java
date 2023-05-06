package com.grindServer.grindServer.alimentosComidas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlimentosComidasService {

    private final AlimentosComidasRepository alimentosComidasRepository;

	@Autowired
	public AlimentosComidasService(AlimentosComidasRepository alimentosComidasRepository) {
		this.alimentosComidasRepository = alimentosComidasRepository;
    }

    public List<AlimentosComidas> getAlimentosComidas() {
		return alimentosComidasRepository.findAll();
	}

	public void addAlimentosComidas(AlimentosComidas Entrenamiento) {
		alimentosComidasRepository.save(Entrenamiento);
	}

	public void deleteAlimentosComidas(Long id) {
		alimentosComidasRepository.deleteById(id);
	}
    
}
