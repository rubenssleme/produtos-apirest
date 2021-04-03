package com.produtos.apirest.repositorios;

import com.produtos.apirest.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
}
