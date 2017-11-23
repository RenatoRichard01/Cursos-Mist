package br.com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.controller.javabeans.Cursos;
import br.com.dao.CursosDao;

@Service
public class ClavasService {

	  @Autowired
	    private CursosDao cursosD;
	  
	  public List<Cursos> pesquisar(String nome){
	    	if (nome != null) {
	    		return cursosD.pesquisarCursos(nome);
	    	}
	    	return cursosD.findAll();
	  }
	  
	  public List<Cursos> salvar(Cursos curso) {
		    cursosD.save(curso);
	    	return cursosD.findAll();
	  }
	  
	  public List<Cursos> deletar(Long id){
		     cursosD.delete(id);
		     return cursosD.findAll();
	  }
	  
	  public List<Cursos> alterar(Cursos curso){
			cursosD.save(curso);
			return cursosD.findAll();
		}
	  
	  
}
