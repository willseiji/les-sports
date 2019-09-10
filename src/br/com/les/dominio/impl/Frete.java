package br.com.les.dominio.impl;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;


public class Frete {
	
	private double valorFrete;
	
	
	
	public double getValorFrete() {
		return valorFrete;
	}



	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}



	public double calcularFrete(List<Item> itens, Endereco endereco) {
		return 0;
	}
}
