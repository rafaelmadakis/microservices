package com.rafael.crud.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.modelmapper.ModelMapper;

import com.rafael.crud.data.vo.ProdutoVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "produto")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false, length = 255)
	private String nome;

	@Column(name = "estoque", nullable = false, length = 10)
	private Integer estoque;

	@Column(name = "preco", nullable = false, length = 10)
	private Double preco;

	public static Produto create(ProdutoVO produtoVO) {
		return new ModelMapper().map(produtoVO, Produto.class);
	}

}
