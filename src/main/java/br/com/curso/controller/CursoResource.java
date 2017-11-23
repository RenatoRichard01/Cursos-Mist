package br.com.curso.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.controller.javabeans.Cursos;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping
public class CursoResource {
	
    @Autowired
    private ClavasService service;
    
    @GetMapping
    public List<Cursos> pesquisar(String nome){
       return service.pesquisar(nome);
    }
    
    @PostMapping
    public List<Cursos> salvar(@RequestBody Cursos curso) {
    	return service.salvar(curso);
	}

	@DeleteMapping("/{id}")
	public List<Cursos> deletar(@PathVariable Long id){
     return service.deletar(id);
	}
	
	@PutMapping
	public List<Cursos> alterar(@RequestBody Cursos curso){
	 return service.alterar(curso);
	}

}
