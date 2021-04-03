package com.produtos.apirest.recursos;

import java.util.List;

import com.produtos.apirest.servicos.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.entidades.Produto;
import com.produtos.apirest.repositorios.ProdutoRepositorio;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoRecurso {

    @Autowired
    ProdutoServico servico;

    @GetMapping("/produtos")
    @ApiOperation(value = "Retorna uma lista de produtos")
    public List<Produto> listaProdutos() {
        return servico.findAll();
    }

    @GetMapping("/produto/{id}")
    @ApiOperation(value = "Retorna um produto unico")
    public Produto listaProdutoPorId(@PathVariable(value = "id") long id) {
        return servico.findById(id);
    }

    @PostMapping("/produto")
    @ApiOperation(value = "Inclui um produto")
    public Produto incluirProduto(@RequestBody Produto produto) {
        return servico.insert(produto);
    }

    @DeleteMapping("/produto")
    @ApiOperation(value = "Deletar um produto")
    public void deletarProduto(@RequestBody Produto produto) {
        servico.delete(produto);
    }

    @PutMapping("/produto")
    @ApiOperation(value = "Atualizar um produto")
    public Produto atualizarProduto(@RequestBody Produto produto) {
        return servico.update(produto);
    }


}
