package com.produtos.apirest.resources;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@Api(value="API REST Categorias")
@CrossOrigin(origins = "*")
public class CategoriaResource {
}
