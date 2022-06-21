package br.edu.ifms.salao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.salao.model.Promocao;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Integer>{

}
