package br.edu.ifms.salao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Servico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String descricao;
	private double valor;
	
	@OneToMany(mappedBy = "cliente")
	private List<Agenda> agendas = new ArrayList<Agenda>();
	
	@ManyToMany
	@JoinTable(
			name="Servico_Profissional",
			joinColumns = @JoinColumn(name="servico_id"),
			inverseJoinColumns = @JoinColumn(name="profissional_id"))
	private List<Profissional> profissionais = new ArrayList<Profissional>();
	
	public Servico() {
		// TODO Auto-generated constructor stub
	}



	public Servico(Integer id, String nome, String descricao, double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	

	public List<Profissional> getProfissionais() {
		return profissionais;
	}

	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}
	
	

	public List<Agenda> getAgendas() {
		return agendas;
	}



	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
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
		Servico other = (Servico) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
		
	
	

}
