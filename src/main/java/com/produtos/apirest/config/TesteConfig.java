package com.produtos.apirest.config;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

import com.produtos.apirest.models.Categoria;
import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.CategoriaRepository;
import com.produtos.apirest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;



@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {

	/*@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	@Autowired
	private PedidoItemRepositorio pedidoItemRepositorio;
	*/
	@Autowired
	private CategoriaRepository categoriaRepositorio;
	@Autowired
	private ProdutoRepository produtoRepositorio;

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Electronics");
		Categoria cat2 = new Categoria(null, "Books");
		Categoria cat3 = new Categoria(null, "Computers");
		Categoria cat4 = new Categoria(null, "Calçados");
		categoriaRepositorio.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));

		Produto p1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.",new BigDecimal("5.00") ,new BigDecimal("90.00"), "https://i.pinimg.com/originals/07/5e/4b/075e4ba8757f8b6f7ee1d0a17895632b.jpg");
		Produto p2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", new BigDecimal("5.00") ,new BigDecimal("2190.00"),"");
		Produto p3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", new BigDecimal("5.00") ,new BigDecimal("15000.00"), "");
		Produto p4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", new BigDecimal("5.00") ,new BigDecimal("1200.00"), "");
		Produto p5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", new BigDecimal("5.00") ,new BigDecimal("190.00"), "");
		produtoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		p1.getCategorias().add(cat2);
		p2.getCategorias().add(cat1);
		p2.getCategorias().add(cat3);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat3);
		p5.getCategorias().add(cat2);

		produtoRepositorio.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		/*Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		Usuario u3 = new Usuario(null, "Arthur Leme", "arthur@gmail.com", "99999999", "654321");
		
		usuarioRepositorio.saveAll(Arrays.asList(u1, u2, u3));

		Pedido pe1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.PAGO, u1);
		Pedido pe2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u2);
		Pedido pe3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);
		pedidoRepositorio.saveAll(Arrays.asList(pe1, pe2, pe3));

		PedidoItem pi1 = new PedidoItem(pe1, p1, 2, p1.getPreco());
		PedidoItem pi2 = new PedidoItem(pe1, p3, 1, p3.getPreco());
		PedidoItem pi3 = new PedidoItem(pe2, p3, 2, p3.getPreco());
		PedidoItem pi4 = new PedidoItem(pe3, p5, 2, p5.getPreco());

		pedidoItemRepositorio.saveAll(Arrays.asList(pi1, pi2, pi3, pi4));

		Pagamento pag1 = new Pagamento(null, Instant.parse("2019-06-20T21:53:07Z"), pe1);
		pe1.setPagamento(pag1);
		pedidoRepositorio.save(pe1);
		*/
	}
}
