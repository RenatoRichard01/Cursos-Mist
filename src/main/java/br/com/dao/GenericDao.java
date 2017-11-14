package br.com.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.sessaoHibernate.HibernateUtil;


public abstract class GenericDao<T, I extends Serializable> {
	
	Session session = HibernateUtil.getSession();
	

	public T adicionar(T entity) {
		 	Transaction transaction = null;
		  		try {
		 		transaction = session.beginTransaction();
		  		session.save(entity);
		 		transaction.commit();
		  			return entity;
		  		} catch (Exception e) {
		  			e.printStackTrace();
		  		}
		  		return null;
		  	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void deletar(T entity) {
		try {
			session.delete(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void alterar(T entity) {
		try {
			session.update(entity);
		} catch (RuntimeException e) {
				e.printStackTrace();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<T> listar(Class<T> classe) {
		List<T> listar = null;
		try {
			Criteria selectAll = session.createCriteria(classe);
			listar = selectAll.list();
		} catch (RuntimeException e) {
			throw e;
		}
		return listar;
	}
	@SuppressWarnings("unchecked")
	public T listarPorId(Class<T> classe, Integer pk) throws Exception {
		try {
			T entity = (T) session.load(classe, pk);
			session.flush();
			return entity;
		} catch (RuntimeException e) {
			throw e;
		}
	}
	@SuppressWarnings("unchecked")
	public List<T> buscarPorNome(String classe, String nome) throws Exception {
		List<T> listagem = null;
		try {
			Query consulta = session.getNamedQuery(classe + ".buscarPorNome");
			consulta.setString("nome", nome);
			listagem = consulta.list();
			session.flush();
			return listagem;
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	
	
}
