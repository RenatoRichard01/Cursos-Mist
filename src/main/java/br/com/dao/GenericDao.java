package br.com.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}
	
	public void deletar(T entity) {
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(entity);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<T> listar(Class<T> classe) {
		Transaction transaction = null;
		List<T> listar = null;
		try {
			transaction = session.beginTransaction();
			Criteria selectAll = session.createCriteria(classe);
			transaction.commit();
			listar = selectAll.list();
		} catch (RuntimeException e) {
			throw e;
		}
		return listar;
	}
	@SuppressWarnings("unchecked")
	public T listarPorId(Class<T> classe, Integer pk) throws Exception {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			T entity = (T) session.load(classe, pk);
			session.flush();
			transaction.commit();
			return entity;
		} catch (RuntimeException e) {
			throw e;
		}
	}
	@SuppressWarnings("unchecked")
	public List<T> buscarPorNome(String classe, String nome) throws Exception {
		Transaction transaction = null;
		List<T> listagem = null;
		try {
			transaction = session.beginTransaction();
			Query consulta = session.getNamedQuery(classe + ".buscarPorNome");
			consulta.setString("nome", nome);
			listagem = consulta.list();
			session.flush();
			transaction.commit();
			return listagem;
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	
	
}
