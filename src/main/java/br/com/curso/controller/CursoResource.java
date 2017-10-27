package br.com.curso.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.controller.javabeans.Cursos;
import br.com.dao.CursosDao;

@RestController
public class CursoResource {
 
  
  CursosDao cDao = new CursosDao();
  @RequestMapping(value = "/listaCursos", method = RequestMethod.GET)
  public ResponseEntity<List<Cursos>> listar() {
    return new ResponseEntity<List<Cursos>>(cDao.listar(Cursos.class), HttpStatus.OK);
  }
}
  
  /*
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
*/
