package br.edu.ifms.salao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.salao.model.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Integer>{

}
