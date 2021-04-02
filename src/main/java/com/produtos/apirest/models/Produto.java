package com.produtos.apirest.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TB_PRODUTO")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	private String nome;
	@NotNull
	private String descricao;
	@NotNull
	private BigDecimal quantidade;
	@NotNull
	private BigDecimal valor;
	@NotNull
	private String imgUrl;

	@ManyToMany
	@JoinTable(name = "tb_produto_categoria",
			joinColumns = @JoinColumn(name ="produto_id"),
			inverseJoinColumns = @JoinColumn(name ="categoria_id"))
	private Set<Categoria> categorias = new HashSet<>();
	public Produto() {

	}

	public Produto(Long id, @NotNull String nome, @NotNull String descricao, @NotNull BigDecimal quantidade, @NotNull BigDecimal valor, @NotNull String imgUrl) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
		this.imgUrl = imgUrl;
	}


	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Produto)) return false;
		Produto produto = (Produto) o;
		return id == produto.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



}
