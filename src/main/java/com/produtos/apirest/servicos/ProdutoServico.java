package com.produtos.apirest.servicos;

import com.produtos.apirest.entidades.Produto;
import com.produtos.apirest.repositorios.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServico {
    @Autowired
    private ProdutoRepositorio repositorio;

    public List<Produto> findAll() {
        return repositorio.findAll();
    }

    public Produto findById(Long id) {
        Optional<Produto> produto = repositorio.findById(id);
        return produto.get();
    }

    public Produto insert(Produto produto) {
        return repositorio.save(produto);
    }

    public void delete(Produto produto) {
        repositorio.delete(produto);
    }

    public Produto update(Produto produto) {
        return repositorio.save(produto);
    }
}
