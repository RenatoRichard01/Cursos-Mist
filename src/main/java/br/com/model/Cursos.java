package br.com.model;

public class Cursos {

	private Integer id;
	  private String nome;
	  private String duracao;
	  
	  public Cursos(Integer id, String nome, String duracao) {
	    this.id = id;
	    this.nome = nome;
	    this.duracao = duracao;
	  }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	
}
