package br.com.qrksCrud.model.builders;

import java.math.BigDecimal;

import br.com.qrksCrud.model.Produto;

public class ProdutoBuilder {
	
	private Produto produto;

	public ProdutoBuilder() {
		//Obrigatório, até o comentário (sugerido pelo sonar)
	}
	
	public static ProdutoBuilder builder(String nome, BigDecimal valor) {
		var produtoBuilder = new ProdutoBuilder();
		produtoBuilder.produto = new Produto();
		produtoBuilder.produto.setNome(nome);
		produtoBuilder.produto.setValor(valor);
		return produtoBuilder;
	}
	
	public ProdutoBuilder colocarValor(BigDecimal valor) {
		produto.setValor(valor);
		return this;
	}
	
	public Produto build() {
		return produto;
	}

}
