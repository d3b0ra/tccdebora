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

import br.edu.ifms.salao.dto.AgendaDto;
import br.edu.ifms.salao.model.Agenda;
import br.edu.ifms.salao.service.AgendaService;

@RestController
@RequestMapping(value = "/agenda")
public class AgendaResource {
	
	
	@Autowired
	private AgendaService agenda;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Agenda> find(@PathVariable Integer id) {		
		Agenda obj = agenda.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AgendaDto objDto) {
		Agenda obj = agenda.fromDTO(objDto);
		obj = agenda.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AgendaDto objDto, @PathVariable Integer id) {
		Agenda obj = agenda.fromDTO(objDto);
		obj.setId(id);
		obj = agenda.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody Agenda obj,@PathVariable Integer id){
		agenda.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AgendaDto>> findAll() {		
		List<Agenda> list = agenda.findAll();
		List<AgendaDto> listDto = list.stream().map(obj -> new AgendaDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
}
