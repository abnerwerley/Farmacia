package com.generation.farmacia.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	/**
	 * Metodo utilizado para retornar pesquisa pela coluna nomeProdutos
	 * 
	 * @param nomeProdutos
	 * @return Lista com nome dos produtos
	 * @author Abner
	 * @since 1.0
	 */

	public List<Produto> findByNomeProdutoContainingIgnoreCase(String nomeProduto);

}
