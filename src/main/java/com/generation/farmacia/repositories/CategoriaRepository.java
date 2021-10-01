package com.generation.farmacia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.models.Categoria;

@Repository
public class CategoriaRepository extends JpaRepository <Categoria, Long>{
		
	

}
