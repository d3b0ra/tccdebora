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

import br.edu.ifms.salao.dto.PromocaoDto;
import br.edu.ifms.salao.model.Promocao;
import br.edu.ifms.salao.service.PromocaoService;

@RestController
@RequestMapping(value = "/promocao")
public class PromocaoResource {
	
	
	@Autowired
	private PromocaoService promocao;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Promocao> find(@PathVariable Integer id) {		
		Promocao obj = promocao.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PromocaoDto objDto) {
		Promocao obj = promocao.fromDTO(objDto);
		obj = promocao.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PromocaoDto objDto, @PathVariable Integer id) {
		Promocao obj = promocao.fromDTO(objDto);
		obj.setId(id);
		obj = promocao.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody Promocao obj,@PathVariable Integer id){
		promocao.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PromocaoDto>> findAll() {		
		List<Promocao> list = promocao.findAll();
		List<PromocaoDto> listDto = list.stream().map(obj -> new PromocaoDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
}
