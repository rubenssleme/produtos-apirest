package com.produtos.apirest.servicos;

import com.produtos.apirest.entidades.Categoria;
import com.produtos.apirest.repositorios.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServico {
    @Autowired
    private CategoriaRepositorio repositorio;

    public List<Categoria> findAll(){
        return repositorio.findAll();
    }
    public Categoria findById(Long id){
        Optional<Categoria> categoria = repositorio.findById(id);
        return categoria.get();
    }
    public Categoria insert(Categoria categoria){
        return repositorio.save(categoria);
    }
    public void delete(Categoria categoria){
            repositorio.delete(categoria);
    }
    public Categoria update(Categoria categoria){
        return repositorio.save(categoria);
    }


}
