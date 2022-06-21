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
public class Agenda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String dataAgenda;	
	private String horaAgenda;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="servico_id")
	private Servico servico;
	
	public Agenda() {
		// TODO Auto-generated constructor stub
	}



	public Agenda(Integer id, String dataAgenda, String horaAgenda, Cliente cliente, Servico servico) {
		super();
		this.id = id;
		this.dataAgenda = dataAgenda;
		this.horaAgenda = horaAgenda;
		this.cliente = cliente;
		this.servico = servico;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataAgenda() {
		return dataAgenda;
	}

	public void setDataAgenda(String dataAgenda) {
		this.dataAgenda = dataAgenda;
	}

	public String getHoraAgenda() {
		return horaAgenda;
	}

	public void setHoraAgenda(String horaAgenda) {
		this.horaAgenda = horaAgenda;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

	public Servico getServico() {
		return servico;
	}



	public void setServico(Servico servico) {
		this.servico = servico;
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
		Agenda other = (Agenda) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	

}
