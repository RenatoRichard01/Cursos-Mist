package br.com.curso.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.controller.javabeans.Cursos;

@RestController
public class CursoResource {
 
  private Map<Integer, Cursos> cursos;
 
  public CursoResource() {
    cursos = new HashMap<Integer, Cursos>();
 
    Cursos c1 = new Cursos(1, "Workshop Rest", "24hs");
    Cursos c2 = new Cursos(2, "Workshop C", "24hs");
    Cursos c3 = new Cursos(3, "Desenvolvimento ", "60hs");
 
    cursos.put(1, c1);
    cursos.put(2, c2);
    cursos.put(3, c3);
  }
 
  @RequestMapping(value = "/cursos", method = RequestMethod.GET)
  public ResponseEntity<List<Cursos>> listar() {
    return new ResponseEntity<List<Cursos>>(new ArrayList<Cursos>(cursos.values()), HttpStatus.OK);
  }
  
  
@RequestMapping(value = "/cursos/{id}", method = RequestMethod.GET)
public ResponseEntity<Cursos> buscar(@PathVariable("id") Integer id) {
	
  Cursos curso = cursos.get(id);
 
  if (curso == null) {
    return new ResponseEntity<Cursos>(HttpStatus.NOT_FOUND);
  }
  return new ResponseEntity<Cursos>(curso, HttpStatus.OK);
  
}


@RequestMapping(value = "/cursos/{id}", method = RequestMethod.DELETE)
public ResponseEntity<?> deletar(@PathVariable("id") int id) {
	
  Cursos curso = cursos.remove(id);
 
  if (curso == null) {
    return new ResponseEntity<Cursos>(HttpStatus.NOT_FOUND);
  }
 
  return new ResponseEntity<Cursos>(HttpStatus.NO_CONTENT);
}

}