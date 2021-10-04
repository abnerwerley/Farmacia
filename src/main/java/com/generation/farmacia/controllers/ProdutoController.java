package com.generation.farmacia.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.farmacia.models.Produto;
import com.generation.farmacia.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/v1/produto")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ProdutoController {

	private @Autowired ProdutoRepository repositorio;

	@GetMapping("/todas")
	public ResponseEntity<List<Produto>> getAll() {
		List<Produto> listaProdutos = repositorio.findAll();

		if (listaProdutos.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaProdutos);
		}
	}

	@GetMapping("/{id_produto}")
	public ResponseEntity<Produto> getById(@PathVariable(value = "id_produtos") Long idProdutos) {
		Optional<Produto> listaProdutos = repositorio.findById(idProdutos);

		if (listaProdutos.isPresent()) {
			return ResponseEntity.status(200).body(listaProdutos.get());
		} else {
			return ResponseEntity.status(204).build();
		}
	}

	@GetMapping("/produto/{nome_Produto}")
	public ResponseEntity<List<Produto>> getAllByNomeProduto(@PathVariable String nomeProduto) {
		return ResponseEntity.ok(repositorio.findAllByNomeProdutoContainingIgnoreCase(nomeProduto));
	}

	@GetMapping("/produto/{preco}")
	public ResponseEntity<List<Produto>> getAllByPreco(@PathVariable Long preco) {
		return ResponseEntity.ok(repositorio.findAllByPrecoContainingIgnoreCase(preco));
	}

	@PostMapping("/salvar")
	public ResponseEntity<Produto> salvar(@Valid @RequestBody Produto novoProduto) {
		return ResponseEntity.status(201).body(repositorio.save(novoProduto));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Produto> atualizar(@Valid @RequestBody Produto novoProduto) {
		return ResponseEntity.status(201).body(repositorio.save(novoProduto));
	}

	@DeleteMapping("/deletar/{id_produto}")
	public ResponseEntity<Produto> deletar(@PathVariable(value = "id_produto") Long idProduto) {
		Optional<Produto> objetoOptional = repositorio.findById(idProduto);

		if (objetoOptional.isPresent()) {
			repositorio.deleteById(idProduto);
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}

}
