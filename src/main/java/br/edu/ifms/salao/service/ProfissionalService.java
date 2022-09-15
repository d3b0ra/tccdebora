package br.edu.ifms.salao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.salao.dto.ProfissionalDto;
import br.edu.ifms.salao.model.Profissional;
import br.edu.ifms.salao.repository.ProfissionalRepository;
import br.edu.ifms.salao.service.exception.DataIntegrityException;
import br.edu.ifms.salao.service.exception.ObjectNotFoundException;

@Service
public class ProfissionalService {
	
	@Autowired
	private ProfissionalRepository repo;
	
	
	public Profissional find(Integer id) {
		Optional<Profissional> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Profissional.class.getName()));		
	}
	
	@Transactional
	public Profissional insert (Profissional obj) {
		obj.setId(null);
		repo.save(obj);
		
		return obj;
		
	}
	
	public Profissional update(Profissional obj) {
		Profissional newObj = find(obj.getId());
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

	public List<Profissional> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	
	
	public Profissional fromDTO(ProfissionalDto objDto) {
		return new Profissional(objDto.getId(), objDto.getNome(),objDto.getTelefone());
	}
	

	
	private void updateData(Profissional newObj, Profissional obj) {
		newObj.setNome(obj.getNome());	
		newObj.setTelefone(obj.getTelefone());	
		
	}

}
