package br.edu.ifms.salao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.salao.dto.ClienteDto;
import br.edu.ifms.salao.model.Cliente;
import br.edu.ifms.salao.repository.ClienteRepository;
import br.edu.ifms.salao.service.exception.DataIntegrityException;
import br.edu.ifms.salao.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	

	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));		
	}
	
	@Transactional
	public Cliente insert (Cliente obj) {
		obj.setId(null);
		repo.save(obj);		
		return obj;
		
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
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

	public List<Cliente> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	public Cliente fromDTO(ClienteDto objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(),objDto.getEmail(),objDto.getTelefone(),null);
	}	
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());	
		newObj.setEmail(obj.getEmail());	
		newObj.setTelefone(obj.getTelefone());	
	}

}
