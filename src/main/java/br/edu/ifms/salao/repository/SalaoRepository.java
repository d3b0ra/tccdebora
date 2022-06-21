package br.edu.ifms.salao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.salao.model.Salao;

@Repository
public interface SalaoRepository extends JpaRepository<Salao, Integer>{

}
