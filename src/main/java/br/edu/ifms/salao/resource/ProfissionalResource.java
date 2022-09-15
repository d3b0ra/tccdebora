package br.edu.ifms.salao.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifms.salao.dto.ProfissionalDto;
import br.edu.ifms.salao.model.Profissional;
import br.edu.ifms.salao.service.ProfissionalService;

@RestController
@RequestMapping(value = "/profissional")
public class ProfissionalResource {
	
	
	@Autowired
	private ProfissionalService profissional;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Profissional> find(@PathVariable Integer id) {		
		Profissional obj = profissional.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ProfissionalDto objDto) {
		Profissional obj = profissional.fromDTO(objDto);
		obj = profissional.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ProfissionalDto objDto, @PathVariable Integer id) {
		Profissional obj = profissional.fromDTO(objDto);
		obj.setId(id);
		obj = profissional.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody Profissional obj,@PathVariable Integer id){
		profissional.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProfissionalDto>> findAll() {		
		List<Profissional> list = profissional.findAll();
		List<ProfissionalDto> listDto = list.stream().map(obj -> new ProfissionalDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
}
