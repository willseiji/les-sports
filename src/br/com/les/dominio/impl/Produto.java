package br.com.les.dominio.impl;

import java.util.ArrayList;
import java.util.List;

public class Produto extends EntidadeDominio {
	private int id;
	private String codigoProd;
	private String nomeProd;
	private String descricao;
	private double peso;
	private String material;
	private String tamanho;
	private int quantidade;
	private double preco;
	private String status;
	private String categoria;
	private String fabricante;
	
	private TabelaPrecificacao tabelaPrec = new TabelaPrecificacao();
	private Imagem imagem = new Imagem();
	private List<Estoque> itensEstoque = new ArrayList<Estoque>();
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigoProd() {
		return codigoProd;
	}
	public void setCodigoProd(String codigoProd) {
		this.codigoProd = codigoProd;
	}
	public String getNomeProd() {
		return nomeProd;
	}
	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public TabelaPrecificacao getTabelaPrec() {
		return tabelaPrec;
	}
	public void setTabelaPrec(TabelaPrecificacao tabelaPrec) {
		this.tabelaPrec = tabelaPrec;
	}
	public Imagem getImagem() {
		return imagem;
	}
	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}
	public List<Estoque> getItensEstoque() {
		return itensEstoque;
	}
	public void setItensEstoque(List<Estoque> itensEstoque) {
		this.itensEstoque = itensEstoque;
	}
	
	
	
}

