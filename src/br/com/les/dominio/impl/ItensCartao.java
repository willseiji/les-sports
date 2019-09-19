package br.com.les.dominio.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="itens_cartao")
public class ItensCartao extends EntidadeDominio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_itens_cartao")
	private int id_itens_cartao;
	@Column
	private double valor_parcela_cartao;
	@Transient
	private CartaoCredito cartao;
	@Column
	private int id_pagamento;
	@Column
	private int id_cartao;

	
	
	public int getId_itens_cartao() {
		return id_itens_cartao;
	}

	public void setId_itens_cartao(int id_itens_cartao) {
		this.id_itens_cartao = id_itens_cartao;
	}

	public CartaoCredito getCartao() {
		return cartao;
	}

	public void setCartao(CartaoCredito cartao) {
		this.cartao = cartao;
	}

	public int getId_pagamento() {
		return id_pagamento;
	}

	public void setId_pagamento(int id_pagamento) {
		this.id_pagamento = id_pagamento;
	}

	public int getId_cartao() {
		return id_cartao;
	}

	public void setId_cartao(int id_cartao) {
		this.id_cartao = id_cartao;
	}

	public double getValor_parcela_cartao() {
		return valor_parcela_cartao;
	}

	public void setValor_parcela_cartao(double valor_parcela_cartao) {
		this.valor_parcela_cartao = valor_parcela_cartao;
	}
	
	
	

}
