package br.edu.ifms.salao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.salao.dto.PromocaoDto;
import br.edu.ifms.salao.model.Promocao;
import br.edu.ifms.salao.repository.PromocaoRepository;
import br.edu.ifms.salao.service.exception.DataIntegrityException;
import br.edu.ifms.salao.service.exception.ObjectNotFoundException;

@Service
public class PromocaoService {
	
	@Autowired
	private PromocaoRepository repo;
	
	
	public Promocao find(Integer id) {
		Optional<Promocao> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Promocao.class.getName()));		
	}
	
	@Transactional
	public Promocao insert (Promocao obj) {
		obj.setId(null);
		repo.save(obj);
		return obj;
		
	}
	
	public Promocao update(Promocao obj) {
		Promocao newObj = find(obj.getId());
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

	public List<Promocao> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	
	
	public Promocao fromDTO(PromocaoDto objDto) {
		return new Promocao(objDto.getId(), objDto.getNome(),objDto.getDescricao(),objDto.getDataValidade(),null);
	}
	
	
	
	private void updateData(Promocao newObj, Promocao obj) {
		newObj.setNome(obj.getNome());	
		newObj.setDescricao(obj.getDescricao());	
		newObj.setDataValidade(obj.getDataValidade());	
		
	}

}
