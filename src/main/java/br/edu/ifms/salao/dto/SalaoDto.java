package br.edu.ifms.salao.dto;

import java.io.Serializable;

import br.edu.ifms.salao.model.Salao;

public class SalaoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String cnpj;
	private String descricao;
	private String telefone;
	
	public SalaoDto() {
		// TODO Auto-generated constructor stub
	}

	public SalaoDto(Salao obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cnpj = obj.getCnpj();
		this.descricao = obj.getDescricao();
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}
