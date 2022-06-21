package br.edu.ifms.salao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifms.salao.dto.UsuariosDto;
import br.edu.ifms.salao.model.Usuarios;
import br.edu.ifms.salao.repository.UsuariosRepository;
import br.edu.ifms.salao.service.exception.DataIntegrityException;
import br.edu.ifms.salao.service.exception.ObjectNotFoundException;

@Service
public class UsuariosService {
	
	@Autowired
	private UsuariosRepository repo;
	
	public Usuarios find(Integer id) {
		Optional<Usuarios> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Usuarios.class.getName()));		
	}
	
	@Transactional
	public Usuarios insert (Usuarios obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}

	public Usuarios update(Usuarios obj) {
		Usuarios newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		Usuarios ex = find(id);
		try {
			repo.deleteById(ex.getId());	
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível remover. Verifique a integridade referencial.");
		}

	}

	public List<Usuarios> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	

	
	public Usuarios fromDTO(UsuariosDto objDto) {
		return new Usuarios(objDto.getId(), objDto.getNome(),objDto.getEmail(),objDto.getSenha());
	}
	
	private void updateData(Usuarios newObj, Usuarios obj) {
		newObj.setNome(obj.getNome());
		newObj.setNome(obj.getEmail());
		newObj.setNome(obj.getSenha());

	}


}
