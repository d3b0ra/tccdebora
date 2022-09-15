package br.edu.ifms.salao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.salao.dto.ServicoDto;
import br.edu.ifms.salao.model.Servico;
import br.edu.ifms.salao.repository.ServicoRepository;
import br.edu.ifms.salao.service.exception.DataIntegrityException;
import br.edu.ifms.salao.service.exception.ObjectNotFoundException;

@Service
public class ServicoService {
	
	@Autowired
	private ServicoRepository repo;
	

	
	public Servico find(Integer id) {
		Optional<Servico> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Servico.class.getName()));		
	}
	
	@Transactional
	public Servico insert (Servico obj) {
		obj.setId(null);
		repo.save(obj);
		return obj;
		
	}
	
	public Servico update(Servico obj) {
		Servico newObj = find(obj.getId());
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

	public List<Servico> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	
	
	public Servico fromDTO(ServicoDto objDto) {
		return new Servico(objDto.getId(), objDto.getNome(),objDto.getDescricao(), objDto.getValor(),objDto.getDuracao());
	}
	
	
	
	private void updateData(Servico newObj, Servico obj) {
		newObj.setNome(obj.getNome());	
		newObj.setDescricao(obj.getDescricao());	
		newObj.setValor(obj.getValor());	
		newObj.setDuracao(obj.getDuracao());	
	}

}
