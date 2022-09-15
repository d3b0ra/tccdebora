package br.edu.ifms.salao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.salao.dto.AgendaDto;
import br.edu.ifms.salao.model.Agenda;
import br.edu.ifms.salao.repository.AgendaRepository;
import br.edu.ifms.salao.service.exception.DataIntegrityException;
import br.edu.ifms.salao.service.exception.ObjectNotFoundException;

@Service
public class AgendaService {
	
	@Autowired
	private AgendaRepository repo;
		
	public Agenda find(Integer id) {
		Optional<Agenda> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Agenda.class.getName()));		
	}
	
	@Transactional
	public Agenda insert (Agenda obj) {
		obj.setId(null);
		repo.save(obj);
		return obj;
		
	}
	
	public Agenda update(Agenda obj) {
		Agenda newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		find(id);
		try {
			repo.deleteById(id);	
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível remover. Verifique a integridade referencial.");
		}
	}

	public List<Agenda> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	
	
	public Agenda fromDTO(AgendaDto objDto) {
		return new Agenda(objDto.getId(), objDto.getDataAgenda(),objDto.getHoraAgenda(),null,null);
	}
	
	
	
	private void updateData(Agenda newObj, Agenda obj) {
		newObj.setDataAgenda(obj.getDataAgenda());	
		newObj.setHoraAgenda(obj.getHoraAgenda());	
			
	}

}
