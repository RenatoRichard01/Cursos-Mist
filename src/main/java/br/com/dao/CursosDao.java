package br.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.curso.controller.javabeans.Cursos;

@Repository
 public interface CursosDao extends JpaRepository<Cursos, Integer>{
	
}
