package com.produtos.apirest.recursos;

import com.produtos.apirest.entidades.Categoria;
import com.produtos.apirest.servicos.CategoriaServico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/categorias")
@Api(value="API REST Categorias")
@CrossOrigin(origins = "*")
public class CategoriaRecurso {
    @Autowired
    CategoriaServico  servico;

    @GetMapping()
    @ApiOperation(value = "Retorna uma lista de produtos")
    public ResponseEntity<List<Categoria>> listaCategoria(){
       List<Categoria> list = servico.findAll();
       return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        Categoria categoria = servico.findById(id);
        return ResponseEntity.ok().body(categoria);
    }
}
