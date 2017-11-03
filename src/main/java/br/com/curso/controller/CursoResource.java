package br.com.curso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.controller.javabeans.Cursos;
import br.com.dao.CursosDao;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CursoResource {

	CursosDao cDao = new CursosDao();

	@RequestMapping(value = "/novoCurso", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<List<Cursos>> salvar (@RequestBody Cursos curso) {
		cDao.adicionar(curso);
		return new ResponseEntity<List<Cursos>>(cDao.listar(Cursos.class), HttpStatus.OK);
	}

	@RequestMapping(value = "/cursoLista", method = RequestMethod.GET)
	public ResponseEntity<List<Cursos>> listar() {
		return new ResponseEntity<List<Cursos>>(cDao.listar(Cursos.class), HttpStatus.OK);
	}


	@RequestMapping(value = "/cursoDeleta/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable("id") int id) throws Exception {
		Cursos c = cDao.listarPorId(Cursos.class, id);
		cDao.deletar(c);
		if (c == null) {
			return new ResponseEntity<Cursos>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Cursos>>(cDao.listar(Cursos.class), HttpStatus.NO_CONTENT);
	}
	
	
	@RequestMapping(value = "/alteraCurso", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<List<Cursos>> alterar(@RequestBody Cursos curso) throws Exception {
		Cursos cursoUp = cDao.listarPorId(Cursos.class, curso.getId());
		cursoUp.setNome(curso.getNome());
		cursoUp.setDuracao(curso.getDuracao());
		cDao.alterar(cursoUp);
		return new ResponseEntity<List<Cursos>>(cDao.listar(Cursos.class), HttpStatus.OK);
	}

	@RequestMapping(value = "/pesquisarNome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<List<Cursos>> buscar(@PathVariable("nome") String nome) throws Exception {
		List<Cursos> listagem = cDao.buscarPorNome("Cursos", nome);
		if(listagem == null){
			return new ResponseEntity<List<Cursos>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Cursos>>(new ArrayList<Cursos>(listagem), HttpStatus.OK);
	}
	
}
