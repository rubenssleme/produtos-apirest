package com.produtos.apirest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

	Produto findById(long id);
	

	
}
