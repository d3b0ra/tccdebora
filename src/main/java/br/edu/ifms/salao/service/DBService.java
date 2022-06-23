package br.edu.ifms.salao.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.salao.model.Cliente;
import br.edu.ifms.salao.model.Profissional;
import br.edu.ifms.salao.model.Promocao;
import br.edu.ifms.salao.model.Salao;
import br.edu.ifms.salao.model.Servico;
import br.edu.ifms.salao.model.Usuarios;
import br.edu.ifms.salao.repository.ClienteRepository;
import br.edu.ifms.salao.repository.ProfissionalRepository;
import br.edu.ifms.salao.repository.PromocaoRepository;
import br.edu.ifms.salao.repository.SalaoRepository;
import br.edu.ifms.salao.repository.ServicoRepository;
import br.edu.ifms.salao.repository.UsuariosRepository;

@Service
public class DBService {
	
	@Autowired
	private UsuariosRepository usuariosRepository;
	@Autowired
	private SalaoRepository salaoRepository;	
	@Autowired
	private ClienteRepository clienteRepository;	
	@Autowired
	private PromocaoRepository promocaoRepository;	
	@Autowired
	private ProfissionalRepository profissionalRepository;	
	@Autowired
	private ServicoRepository servicoRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		
		Usuarios user1 = new Usuarios(null, "Debora Castro","debora.rojas@estudante.if,s.edu.br","123456");

		Salao sa1 = new Salao(null, "Espaço Beleza","CNPJ do Salao","descricao do salao Espaço Beleza","67 99987 7898", user1);
		Salao sa2 = new Salao(null, "salao dos colombia","CNPJ do Salao dos colombia","descricao do salao colombia","67 9876 5443", user1);
		Salao sa3 = new Salao(null, "Salao do Gigio","CNPJ do Salao","descricao do salao giggio","67 9786 4567", user1);
		

		Cliente cli1 = new Cliente(null, "Maria Joaquina", "67 9 98987654", "m.joaquina@gmail.com", sa1);
		Cliente cli2 = new Cliente(null, "Patricia", "67 9 98987654", "m.joaquina@gmail.com", sa1);
		Cliente cli3 = new Cliente(null, "Ana", "67 9 98987654", "m.joaquina@gmail.com", sa1);
		Cliente cli4 = new Cliente(null, "Roosevelt Silva", "67 9 98987654", "m.joaquina@gmail.com", sa3);
		Cliente cli5 = new Cliente(null, "Luis Freitas", "67 9 98987654", "m.joaquina@gmail.com", sa3);
		Cliente cli6 = new Cliente(null, "Lucas Santos", "67 9 98987654", "m.joaquina@gmail.com", sa3);
		Cliente cli7 = new Cliente(null, "Luis Jimenez", "67 9 98987654", "m.joaquina@gmail.com", sa2);
		Cliente cli8 = new Cliente(null, "Jean Rojas", "67 9 98987654", "m.joaquina@gmail.com", sa2);
		Cliente cli9 = new Cliente(null, "Rafael Francozo", "67 9 98987654", "m.joaquina@gmail.com", sa2);
		
		Promocao pro1= new Promocao(null,"Promocao de escova japonesa", "alisamento", "10 dias", sa1);
		Promocao pro2= new Promocao(null,"Promocao de sombrancelhas fio a fio", "tatuagem", "5 dias", sa3);
		Promocao pro3= new Promocao(null,"Promocao de corte de cabelo", "Maquina e tesoura", "7 dias", sa2);
		
		
		sa1.getClientes().addAll(Arrays.asList(cli1,cli2,cli3));
		sa2.getClientes().addAll(Arrays.asList(cli7,cli8,cli9));
		sa3.getClientes().addAll(Arrays.asList(cli4,cli5,cli6));
		
		sa1.getPromocoes().addAll(Arrays.asList(pro1));
		sa2.getPromocoes().addAll(Arrays.asList(pro3));
		sa3.getPromocoes().addAll(Arrays.asList(pro2));
		
		
		
		Profissional p1 = new Profissional(null, "Niva", "67 9 9878 5678");
		Profissional p2 = new Profissional(null, "Suellen", "67 9 9878 5678");
		Profissional p3 = new Profissional(null, "Nathan", "67 9 9878 5678");
		
		Servico s1 = new Servico(null, "Alisamento","escova alisadora",250.0,240);
		Servico s2 = new Servico(null, "Unha em gel","descricao da unha em gel",180.0,120);
		Servico s3 = new Servico(null, "Depilação","descricao da depilacao",50.0,30);
		Servico s4 = new Servico(null, "Megahair","descricao do megahair",3000.0,240);
		Servico s5 = new Servico(null, "Tintura","descricao de tintura",70.0,30);
		Servico s6 = new Servico(null, "Descoloração","descricao da descoloracao",400.0,300);
		
		p1.getServicos().addAll(Arrays.asList(s1,s3,s6));
		p2.getServicos().addAll(Arrays.asList(s2,s3,s4));
		p3.getServicos().addAll(Arrays.asList(s1,s5,s6));
		
		s1.getProfissionais().addAll(Arrays.asList(p1,p3));
		s2.getProfissionais().addAll(Arrays.asList(p2));
		s3.getProfissionais().addAll(Arrays.asList(p1,p2));
		s4.getProfissionais().addAll(Arrays.asList(p2));
		s5.getProfissionais().addAll(Arrays.asList(p3));
		s6.getProfissionais().addAll(Arrays.asList(p1,p3));
		
		
		
		
		user1.getSaloes().addAll(Arrays.asList(sa1,sa2,sa3));
				
		usuariosRepository.saveAll(Arrays.asList(user1));		
		salaoRepository.saveAll(Arrays.asList(sa1, sa2, sa3));
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4,cli5,cli6,cli7,cli8,cli9));
		promocaoRepository.saveAll(Arrays.asList(pro1,pro2,pro3));
		
		profissionalRepository.saveAll(Arrays.asList(p1,p2,p3));
		servicoRepository.saveAll(Arrays.asList(s1,s2,s3,s4,s5,s6));
		
		
	}

}
