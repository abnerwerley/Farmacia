package com.generation.farmacia.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name = "tb_produtos")
	public class Produtos {

		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idProduto;
		
		@NotBlank
		private String nomeProdutos;
		
		@NotBlank
		private Double preco;
		
		@NotBlank 
		private String tipoProduto;
		
		
		@ManyToOne
		@JoinColumn(name = "id_categoria")
		@JsonIgnoreProperties({ "produtos" })
		private  Categoria categoriaRelacionada;


		public Long getIdProduto() {
			return idProduto;
		}


		public void setIdProduto(Long idProduto) {
			this.idProduto = idProduto;
		}


		public String getNomeProdutos() {
			return nomeProdutos;
		}


		public void setNomeProdutos(String nomeProdutos) {
			this.nomeProdutos = nomeProdutos;
		}


		public Double getPreco() {
			return preco;
		}


		public void setPreco(Double preco) {
			this.preco = preco;
		}


		public String getTipoProduto() {
			return tipoProduto;
		}


		public void setTipoProduto(String tipoProduto) {
			this.tipoProduto = tipoProduto;
		}


		public Categoria getCategoriaRelacionada() {
			return categoriaRelacionada;
		}


		public void setCategoriaRelacionada(Categoria categoriaRelacionada) {
			this.categoriaRelacionada = categoriaRelacionada;
		}
		
}
