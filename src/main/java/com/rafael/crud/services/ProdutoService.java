package com.rafael.crud.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.rafael.crud.Exception.ResourceNotFoudException;
import com.rafael.crud.data.vo.ProdutoVO;
import com.rafael.crud.entity.Produto;
import com.rafael.crud.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;

	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public ProdutoVO create(ProdutoVO produtoVO) {
		ProdutoVO proVoRetorno = ProdutoVO.create(produtoRepository.save(Produto.create(produtoVO)));
		return proVoRetorno;

	}

	public Page<ProdutoVO> findAll(Pageable pageable) {
		var page = produtoRepository.findAll(pageable);
		return page.map(this::convertToProdutoVO);
	}

	private ProdutoVO convertToProdutoVO(Produto produto) {
		return ProdutoVO.create(produto);
	}

	public ProdutoVO findbyId(Long id) {
		var entity = produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoudException("No records found for this ID"));
		return ProdutoVO.create(entity);
	}

	public ProdutoVO update(ProdutoVO produtoVO) {
		final Optional<Produto> optionalProduto = produtoRepository.findById(produtoVO.getId());

		if (!optionalProduto.isPresent()) {
			new ResourceNotFoudException("No records found for this ID");
		}
		return ProdutoVO.create(produtoRepository.save(Produto.create(produtoVO)));

	}

	public void detele(Long id) {
		var entity = produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoudException("No records found for this ID"));

		produtoRepository.delete(entity);

	}

}
