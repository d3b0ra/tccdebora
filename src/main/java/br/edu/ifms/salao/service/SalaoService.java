package br.edu.ifms.salao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.salao.dto.SalaoDto;
import br.edu.ifms.salao.model.Salao;
import br.edu.ifms.salao.repository.ClienteRepository;
import br.edu.ifms.salao.repository.SalaoRepository;
import br.edu.ifms.salao.service.exception.DataIntegrityException;
import br.edu.ifms.salao.service.exception.ObjectNotFoundException;

@Service
public class SalaoService {
	
	@Autowired
	private SalaoRepository repo;
	@Autowired
	private ClienteRepository cliente;

	
	public Salao find(Integer id) {
		Optional<Salao> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Salao.class.getName()));		
	}
	
	@Transactional
	public Salao insert (Salao obj) {
		obj.setId(null);
		repo.save(obj);
		cliente.saveAll(obj.getClientes());
		return obj;
		
	}
	
	public Salao update(Salao obj) {
		Salao newObj = find(obj.getId());
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

	public List<Salao> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	
	
	public Salao fromDTO(SalaoDto objDto) {
		return new Salao(objDto.getId(), objDto.getNome(),objDto.getCnpj(),objDto.getDescricao(), objDto.getTelefone(),null);
	}
	
	/*
	public Salao fromDTO(CmaNewDTO objDto) {
		Salao sa = new Salao(null, objDto.getNome(),null);
		Gu not = new Gu(null, objDto.getNomeGu(),nuc);
		nuc.getGus().add(not);
		return nuc;
	}*/
	
	private void updateData(Salao newObj, Salao obj) {
		newObj.setNome(obj.getNome());	
		newObj.setNome(obj.getCnpj());	
		newObj.setNome(obj.getDescricao());	
		newObj.setNome(obj.getTelefone());	
	}

}
