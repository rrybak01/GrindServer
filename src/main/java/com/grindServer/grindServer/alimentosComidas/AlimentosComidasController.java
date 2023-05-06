package com.grindServer.grindServer.alimentosComidas;

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
@RequestMapping(path = "alimetoscomidas/")
public class AlimentosComidasController {

    private final AlimentosComidasService alimentosComidasService;

    @Autowired
    public AlimentosComidasController(AlimentosComidasService alimentosComidasService){
        this.alimentosComidasService = alimentosComidasService;
    }
    
    @GetMapping
	public List<AlimentosComidas> getAlimentosComidas(){
        return alimentosComidasService.getAlimentosComidas();
    }

    @PostMapping
    public void postAlimentosComidas(@RequestBody AlimentosComidas ejercicio){
        alimentosComidasService.addAlimentosComidas(ejercicio);
    }

    @DeleteMapping("{id}")
	public void deleteAlimentosComidas(@PathVariable("id") Long id){
		alimentosComidasService.deleteAlimentosComidas(id);
	}

}
