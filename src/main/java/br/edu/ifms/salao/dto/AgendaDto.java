package br.edu.ifms.salao.dto;

import java.io.Serializable;

import br.edu.ifms.salao.model.Agenda;

public class AgendaDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String dataAgenda;
	private String horaAgenda;
	
	public AgendaDto() {
		// TODO Auto-generated constructor stub
	}

	public AgendaDto(Agenda obj) {
		super();
		this.id = obj.getId();
		this.dataAgenda = obj.getDataAgenda();
		this.horaAgenda = obj.getHoraAgenda();
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
	
	
	
	

}
