package br.com.les.dominio.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="item_troca")
public class ItemTroca extends EntidadeDominio{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_item_troca")
	private int id;
	@Column
	private int qtdeTrocada;
	@Column
	private double preco;
	@Transient
	private Produto produto;
	@Column
	private int id_troca;
	@Column
	private int id_produto;
	
	@Column(name="valor_troca")
	private double valor_troca;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQtdeTrocada() {
		return qtdeTrocada;
	}

	public void setQtdeTrocada(int qtdeTrocada) {
		this.qtdeTrocada = qtdeTrocada;
	}

	
	
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getId_troca() {
		return id_troca;
	}

	public void setId_troca(int id_troca) {
		this.id_troca = id_troca;
	}
	
	
	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	
	public void setValorTroca() {
		this.valor_troca = valorTroca();
	}
	public double valorTroca() {
		return getQtdeTrocada()*getPreco();
	}
	
	
	
}
