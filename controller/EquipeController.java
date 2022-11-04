package br.edu.ifba.back.gincana.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
 
import br.edu.ifba.back.gincana.model.EquipeModel;
import br.edu.ifba.back.gincana.repository.GincanaRepository;

@RestController
@RequestMapping("/equipes")
public class EquipeController {
	
	private GincanaRepository repository;
	
	public EquipeController(GincanaRepository repository) {
		super();
		this.repository = repository;
	}

	@GetMapping
	public String teste() {
		return "Testando Rota Usuario";
	}
	

	@GetMapping("/listall")
	public List<EquipeModel> listall() {
		var equipe = repository.findAll();
		return equipe;
	}

	
	@GetMapping("/{idEquipe}")
    public EquipeModel findById(@PathVariable("idEquipe") Long idEquipe) {
		Optional<EquipeModel> obj = repository.findById(idEquipe);
		if ( obj.isPresent() )
			return obj.get();
        return null;
    }
	
	@PostMapping("/")
	@ResponseStatus( HttpStatus.CREATED )
	public boolean insert(@RequestBody EquipeModel model){
		System.out.println("server - insert: " + model);
		try {
			repository.save(model);
			System.out.println("server - insert: TRUE");
			return true;
		}
		catch (Exception e) {
			System.out.println("server - insert: FALSE");
			e.printStackTrace();
			return false;
		}
	}
	
	@DeleteMapping("/{idEquipe}")
	@ResponseStatus( HttpStatus.ACCEPTED )
	public boolean delete(@PathVariable("idEquipe") Long idEquipe) {
		System.out.println("delete");
		try {
			repository.deleteById(idEquipe);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	
	@PutMapping("/{idEquipe}")
	@ResponseStatus( HttpStatus.CREATED )
	public ResponseEntity<EquipeModel> update(@PathVariable("idEquipe") Long idEquipe, @RequestBody EquipeModel equipeModel) {
		var p = repository.findById(idEquipe);
        if (p.isPresent()) {
            var gincana = p.get();
            if ( equipeModel.getNome_Equipe() != null )
            	gincana.setNome_Equipe(equipeModel.getNome_Equipe());
            if ( equipeModel.getCurso_Equipe() != null )
            	gincana.setCurso_Equipe(equipeModel.getCurso_Equipe());
            if ( equipeModel.getRepresentante_Equipe() != null )
            	gincana.setRepresentante_Equipe(equipeModel.getRepresentante_Equipe());
       //     if ( equipeModel.getIdGincana() != null )
            //	gincana.setIdGincana(equipeModel.getIdGincana());
            repository.save(gincana);
            return ResponseEntity.ok(gincana);
        } else {
        	return ResponseEntity.notFound().build();
        }
	}
}
