package br.com.curso.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.controller.javabeans.Cursos;
import br.com.dao.CursosDao;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/clavas")
public class CursoResource {
	
    @Autowired
    private CursosDao cursosD;
    
    @GetMapping
    public List<Cursos> lista(){
    	return cursosD.findAll();
    }
    
    @PostMapping
    public List<Cursos> salvar(@RequestBody Cursos curso) {
		cursosD.save(curso);
		return cursosD.findAll();
	}

	@DeleteMapping("/{id}")
	public List<Cursos> deletar(@PathVariable Integer id){
     cursosD.delete(id);
     return cursosD.findAll();
	} 
	
	
	/*@RequestMapping(value = "/", method = RequestMethod.PUT)
	*@ResponseBody
	*public ResponseEntity<List<Cursos>> alterar(@RequestBody Cursos curso) throws Exception {
	*	Cursos cursoUp = cDao.listarPorId(Cursos.class, curso.getId());
	*	cursoUp.setNome(curso.getNome());
	*	cursoUp.setDuracao(curso.getDuracao());
	*	cDao.alterar(cursoUp);
	*	return new ResponseEntity<List<Cursos>>(cDao.listar(Cursos.class), HttpStatus.OK);
	*}
    */
	/*@RequestMapping(value = "/{nome}", method = RequestMethod.GET)
	*public ResponseEntity<List<Cursos>> buscarPorNome(@PathVariable("nome") String nome) throws Exception {
	*	List<Cursos> listagem = cDao.findByName(nome);
	*	if(listagem == null){
	*		return new ResponseEntity<List<Cursos>>(HttpStatus.NOT_FOUND);
	*	}
	*	return new ResponseEntity<List<Cursos>>(new ArrayList<Cursos>(listagem), HttpStatus.OK);
	*}
	*/
}
