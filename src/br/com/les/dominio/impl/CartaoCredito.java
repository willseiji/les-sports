package br.com.les.dominio.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="cartao")
public class CartaoCredito extends EntidadeDominio {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cartao")
	private int id;
	@Column(name="bandeira")
	private String bandeira;
	@Column(name="numero")
	private String numero;
	@Column(name="nome_titular")
	private String nomeTitular;
	@Column(name="cv")
	private String codigoSeguranca;
	@Column(name="vencimento")
	private String dataValidade;
	@Column(name="id_cliente")
	private int id_cliente;
	@Transient
	private FormaPagamento formaPgto;
	@Column(name="principal")
	private String principal;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBandeira() {
		return bandeira;
	}
	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNomeTitular() {
		return nomeTitular;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public String getCodigoSeguranca() {
		return codigoSeguranca;
	}
	public void setCodigoSeguranca(String codigoSeguranca) {
		this.codigoSeguranca = codigoSeguranca;
	}
	public String getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public FormaPagamento getFormaPgto() {
		return formaPgto;
	}
	public void setFormaPgto(FormaPagamento formaPgto) {
		this.formaPgto = formaPgto;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	
	
	
}
