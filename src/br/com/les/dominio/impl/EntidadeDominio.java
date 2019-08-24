package br.com.les.dominio.impl;

import br.com.les.dominio.IEntidade;

public class EntidadeDominio implements IEntidade {
	 private int id;
	 private String date;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	 
	 
}
