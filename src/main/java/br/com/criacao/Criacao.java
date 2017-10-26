package br.com.criacao;

import br.com.sessaoHibernate.HibernateUtil;

public class Criacao {
	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}
}
