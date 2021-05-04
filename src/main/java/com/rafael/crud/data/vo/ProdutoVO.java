package com.rafael.crud.data.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.rafael.crud.entity.Produto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonPropertyOrder({ "id", "nome", "estoque", "preco" })
@Data
@EqualsAndHashCode
public class ProdutoVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("estoque")
	private Integer estoque;

	@JsonProperty("preco")
	private Double preco;

	public static ProdutoVO create(Produto produto) {
		return new ModelMapper().map(produto, ProdutoVO.class);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
