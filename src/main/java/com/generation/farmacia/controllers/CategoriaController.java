package com.generation.farmacia.controllers;

/**
 * Métodos CRUD de Categoria
 * 
 * @author Daniel
 * @since 1.0
 * 
 */
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

import com.generation.farmacia.models.Categoria;
import com.generation.farmacia.repositories.CategoriaRepository;

@RestController
@RequestMapping("/api/v1/categoria")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CategoriaController {

	private @Autowired CategoriaRepository repositorio;

	/**
	 * Retonra a lista com todas as Categorias
	 * 
	 * @return Lista com todas as categorias
	 */
	@GetMapping("/todos")
	public ResponseEntity<List<Categoria>> getAll() {
		List<Categoria> Lista = repositorio.findAll();

		if (Lista.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(Lista);
		}
	}

	/**
	 * Retorna a Categoria com o idCategoria
	 * 
	 * @param idCategoria
	 * @return
	 */
	@GetMapping("/{id_categoria}")
	public ResponseEntity<Categoria> getById(@PathVariable(value = "id_categoria") Long idCategoria) {
		Optional<Categoria> objetoOptional = repositorio.findById(idCategoria);

		if (objetoOptional.isPresent()) {
			return ResponseEntity.status(200).body(objetoOptional.get());
		} else {
			return ResponseEntity.status(204).build();
		}
	}

	@GetMapping("/descricao/{descricao_categoria}")
	public ResponseEntity<List<Categoria>> getAllByDescricaoCategoria(
			@PathVariable(value = "descricao_categoria") String descricaoCategoria) {
		List<Categoria> Lista = repositorio.findAllByDescricaoCategoriaContainingIgnoreCase(descricaoCategoria);

		if (Lista.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(Lista);
		}
	}

	@PostMapping("/salvar")
	public ResponseEntity<Categoria> salvar(@Valid @RequestBody Categoria novaCategoria) {
		return ResponseEntity.status(201).body(repositorio.save(novaCategoria));
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Categoria> atualizar(@Valid @RequestBody Categoria novaCategoria) {
		return ResponseEntity.status(201).body(repositorio.save(novaCategoria));
	}

	@DeleteMapping("/deletar/{id_categoria}")
	public ResponseEntity<Categoria> deletar(@PathVariable(value = "id_categoria") Long idCategoria) {
		Optional<Categoria> objetoOptional = repositorio.findById(idCategoria);

		if (objetoOptional.isPresent()) {
			repositorio.deleteById(idCategoria);
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(400).build();
		}
	}
}
