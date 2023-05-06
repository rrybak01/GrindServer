package com.grindServer.grindServer.alimento;
import java.util.List;

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
@RequestMapping(path = "alimentos/")
public class AlimentoController {

    private final AlimentoService alimentoService;

    @Autowired
    public AlimentoController(AlimentoService alimentoService){
        this.alimentoService = alimentoService;
    }

    @GetMapping
	public List<Alimento> getAlimentos(){
        return alimentoService.getAlimentos();
    }

    @PostMapping
    public void postAlimento(@RequestBody Alimento alimento){
        alimentoService.addAlimento(alimento);
    }

    @DeleteMapping("{id}")
	public void deleteAlimento(@PathVariable("id") Long id){
		alimentoService.deleteAlimento(id);
	}

    @PutMapping("{id}")
    public void updateAlimento(
        @PathVariable("id") Long id,
        @RequestParam(required = false) String nombre,
        @RequestParam(required = false) Integer proteinas,
        @RequestParam(required = false) Integer hidratos,
        @RequestParam(required = false) Integer grasas){
            alimentoService.updateAlimento(id, nombre, proteinas, hidratos, grasas);
    }
    
}
