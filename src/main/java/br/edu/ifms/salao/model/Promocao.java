package br.edu.ifms.salao.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Promocao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private String dataValidade;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="salao_id")
	private Salao salao;
	
	public Promocao() {
		// TODO Auto-generated constructor stub
	}

	public Promocao(Integer id, String nome, String descricao, String dataValidade, Salao salao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataValidade = dataValidade;
		this.salao = salao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Salao getSalao() {
		return salao;
	}

	public void setSalao(Salao salao) {
		this.salao = salao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promocao other = (Promocao) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
