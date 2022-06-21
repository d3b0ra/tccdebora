package br.edu.ifms.salao.resource;

import java.util.List;
import java.net.URI;
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
import br.edu.ifms.salao.dto.SalaoDto;
import br.edu.ifms.salao.model.Salao;
import br.edu.ifms.salao.service.SalaoService;

@RestController
@RequestMapping(value = "/salao")
public class SalaoResource {
	
	
	@Autowired
	private SalaoService salao;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Salao> find(@PathVariable Integer id) {		
		Salao obj = salao.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody SalaoDto objDto) {
		Salao obj = salao.fromDTO(objDto);
		obj = salao.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody SalaoDto objDto, @PathVariable Integer id) {
		Salao obj = salao.fromDTO(objDto);
		obj.setId(id);
		obj = salao.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody Salao obj,@PathVariable Integer id){
		salao.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SalaoDto>> findAll() {		
		List<Salao> list = salao.findAll();
		List<SalaoDto> listDto = list.stream().map(obj -> new SalaoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
}
