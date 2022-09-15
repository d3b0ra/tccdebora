package br.edu.ifms.salao.dto;

import java.io.Serializable;

import br.edu.ifms.salao.model.Profissional;

public class ProfissionalDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	
	private String nome;
	private String telefone;
	
	public ProfissionalDto() {
		// TODO Auto-generated constructor stub
	}

	public ProfissionalDto(Profissional obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.telefone = obj.getTelefone();
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
	

}
