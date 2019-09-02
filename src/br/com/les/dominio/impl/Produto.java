package br.com.les.dominio.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="produto")
public class Produto extends EntidadeDominio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_produto")
	private int id;
	@Transient
	private String data;
	@Column(name="codigo")
	private String codigoProd;
	@Column(name="nome")
	private String nome;
	@Column(name="descricao")
	private String descricao;
	@Column(name="peso")
	private double peso;
	@Column(name="material")
	private String material;
	@Column(name="tamanho")
	private String tamanho;
	@Column(name="quantidade")
	private int quantidade;
	@Column(name="preco")
	private double preco;
	@Column(name="status")
	private String status;
	@Column(name="categoria")
	private String categoria;
	@Column(name="fabricante")
	private String fabricante;
	@Transient
	private TabelaPrecificacao tabelaPrec = new TabelaPrecificacao();
	@Transient
	private Imagem imagem = new Imagem();
	@Transient
	private List<Estoque> itensEstoque = new ArrayList<Estoque>();
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getCodigoProd() {
		return codigoProd;
	}
	public void setCodigoProd(String codigoProd) {
		this.codigoProd = codigoProd;
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

