package br.com.test.excluir;


import br.com.curso.controller.javabeans.Cursos;
import br.com.dao.CursosDao;

public class ExcluiCurso {

	public static void main(String[] args) throws Exception {
		CursosDao dao = new CursosDao();
		Cursos curso = dao.listarPorId(Cursos.class, 1);
		dao.deletar(curso);
		
		
	}
}
