package com.generation.farmacia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public class CategoriaRepository extends JpaRepository <categoria, Long>{
		
	/**
	 * @return Lista com todos as descriçoes que contenham a palavra digitada
	 * @author George
	 * @since 1.0
	 */
	public List<Categoria> findAllByDescricaoCategoriaContainingIgnoreCase(String descricaoCategoria);


}
