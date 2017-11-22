package br.com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import br.com.curso.controller.javabeans.Cursos;

@Repository
 public interface CursosDao extends JpaRepository<Cursos, Long>{
	Cursos findByNome(String nome);
	
	  @Query("from Cursos where nome like concat(?1, '%')")
	    List<Cursos> pesquisarCursos(String nome);
}
