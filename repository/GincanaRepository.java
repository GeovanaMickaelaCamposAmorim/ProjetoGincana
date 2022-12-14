package br.edu.ifba.back.gincana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifba.back.gincana.model.EquipeModel;

@Repository
public interface GincanaRepository 
	extends JpaRepository<EquipeModel, Long>
{

}
