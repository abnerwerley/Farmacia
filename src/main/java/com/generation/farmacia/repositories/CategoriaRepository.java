package com.generation.farmacia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.models.Categoria;

@Repository
public class CategoriaRepository extends JpaRepository <Categoria, Long>{
		
	/**
	 *@author George
	 *@since 1.0
	 */
	public List<Categoria> findAllByDescricaoCategoriaContainingIgnoreCase(String descricaoCategoria);


}
