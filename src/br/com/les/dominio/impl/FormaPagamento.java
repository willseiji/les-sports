package br.com.les.dominio.impl;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="forma_pagamento")
public class FormaPagamento extends EntidadeDominio{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_pagamento")
	private int id;
	@Column
	private int qtdeParcelas;
	@Column
	private double valorParcelas;
	@Transient
	private List<ItensCartao> itensCartao;
	@Column(name="id_pedido")
	private int id_pedido;
	
	
	public int getQtdeParcelas() {
		return qtdeParcelas;
	}

	public void setQtdeParcelas(int qtdeParcelas) {
		this.qtdeParcelas = qtdeParcelas;
	}

	public double getValorParcelas() {
		return valorParcelas;
	}

	public void setValorParcelas(double valorParcelas) {
		this.valorParcelas = valorParcelas;
	}

	public List<ItensCartao> getItensCartao() {
		return itensCartao;
	}

	public void setItensCartao(List<ItensCartao> itensCartao) {
		this.itensCartao = itensCartao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	
	
	

}
