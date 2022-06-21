package br.edu.ifms.salao.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.salao.model.Salao;
import br.edu.ifms.salao.model.Usuarios;
import br.edu.ifms.salao.repository.SalaoRepository;
import br.edu.ifms.salao.repository.UsuariosRepository;

@Service
public class DBService {
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	@Autowired
	private SalaoRepository salaoRepository;	
	
	public void instantiateTestDatabase() throws ParseException {
		
		Usuarios user1 = new Usuarios(null, "Debora Castro","debora.rojas@estudante.if,s.edu.br","123456");

		Salao sa1 = new Salao(null, "Espaço Beleza","CNPJ do Salao","descricao do salao Espaço Beleza","67 99987 7898", user1);
		Salao sa2 = new Salao(null, "salao dos colombia","CNPJ do Salao dos colombia","descricao do salao colombia","67 9876 5443", user1);
		Salao sa3 = new Salao(null, "Salao do Gigio","CNPJ do Salao","descricao do salao giggio","67 9786 4567", user1);
		

		user1.getSaloes().addAll(Arrays.asList(sa1,sa2,sa3));
				
		usuariosRepository.saveAll(Arrays.asList(user1));
		
		salaoRepository.saveAll(Arrays.asList(sa1, sa2, sa3));
		
	}

}
