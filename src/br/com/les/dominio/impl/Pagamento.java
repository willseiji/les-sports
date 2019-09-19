package br.com.les.dominio.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="pagamento")
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pagamento")
	private int id;
	@Column(name="total")
	private double total;
	@Transient
	private FormaPagamento formaPgto;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public FormaPagamento getFormaPgto() {
		return formaPgto;
	}
	public void setFormaPgto(FormaPagamento formaPgto) {
		this.formaPgto = formaPgto;
	}
	
	
	
}
