package br.com.curso.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.controller.javabeans.Cursos;
import br.com.dao.CursosDao;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CursoResource {

	CursosDao cDao = new CursosDao();

	@RequestMapping(value = "/cursoAdiciona/{nome}/{duracao}", method = RequestMethod.GET)
	public ResponseEntity<List<Cursos>> salvar(@PathVariable("nome")String nome,
			@PathVariable("duracao")String duracao) {
		Cursos curso = new Cursos();
		curso.setNome(nome);
		curso.setDuracao(duracao);
		cDao.adicionar(curso);
		return new ResponseEntity<List<Cursos>>(cDao.listar(Cursos.class), HttpStatus.OK);
	}

	@RequestMapping(value = "/cursoLista", method = RequestMethod.GET)
	public ResponseEntity<List<Cursos>> listar() {
		return new ResponseEntity<List<Cursos>>(cDao.listar(Cursos.class), HttpStatus.OK);
	}

	

	@RequestMapping(value = "/cursoPorId/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cursos> buscar(@PathVariable("id") Integer id) throws Exception {
		Cursos curso = cDao.listarPorId(Cursos.class, id);
		if (curso == null) {
			return new ResponseEntity<Cursos>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cursos>(curso, HttpStatus.OK);
	}

	@RequestMapping(value = "/cursoDeleta/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable("id") int id) throws Exception {
		Cursos c = cDao.listarPorId(Cursos.class, id);
		cDao.deletar(c);
		if (c == null) {
			return new ResponseEntity<Cursos>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Cursos>(HttpStatus.NO_CONTENT);
	}
}
